package com.example.tradememembership.services;

import com.example.tradememembership.entities.MembershipWorkflowEntity;
import com.example.tradememembership.models.Workflow.MembershipWorkflowRequestBody;
import com.example.tradememembership.models.Workflow.Stage;
import com.example.tradememembership.models.Workflow.MembershipWorkflow;
import com.example.tradememembership.repositories.MembershipWorkflowRepository;
import com.example.tradememembership.utils.UserNotFoundException;
import com.example.tradememembership.utils.WorkFlowNotDeleted;
import com.example.tradememembership.utils.mappers.MembershipWorkflowEntityMapper;
import com.example.tradememembership.utils.mappers.MembershipWorkflowMapper;
import com.example.tradememembership.utils.mappers.WorkflowToMemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembershipWorkflowService {

    private final MembershipWorkflowRepository membershipWorkflowRepository;
    private final MembershipWorkflowMapper toWorkflow;
    private final MembershipWorkflowEntityMapper toWorkflowEntity;
    private final MemberService memberService;
    private final RegulationService regulationService;
    private final WorkflowToMemberEntity toMemberEntity;

    public MembershipWorkflow save(MembershipWorkflowRequestBody body) {
        var membershipWorkflowEntity = toWorkflowEntity.from(body);
        membershipWorkflowEntity.setStage(Stage.regulation);
        membershipWorkflowEntity.setPassword(hashPassword(membershipWorkflowEntity.getPassword()));

        var regulationInserted = regulationService.createRegulation(body.getEmail());
        if(!regulationInserted) {
            throw new RuntimeException("Your application can't be done for the moment");
        }
        var membershipWorkflowEntityInserted = membershipWorkflowRepository.save(membershipWorkflowEntity);

        return toWorkflow.from(membershipWorkflowEntityInserted);
    }

    public Boolean existByEmail(String email) {
        return membershipWorkflowRepository.existsByEmail(email);
    }

    public MembershipWorkflowEntity findByEmail(String email) {
        return membershipWorkflowRepository.findByEmail(email);
    }

    public MembershipWorkflow findOneByEmail(String email) {
        var optionalMembershipWorkflow = findAll().stream()
                .filter(membershipWorkflow -> membershipWorkflow.getEmail().equals(email))
                .findFirst();

        if (optionalMembershipWorkflow.isEmpty()) {
            throw new UserNotFoundException();
        }

        return optionalMembershipWorkflow.get();
    }

    public List<MembershipWorkflow> findAll() {
        return membershipWorkflowRepository.findAll().stream()
                .map(workflowEntity -> toWorkflow.from(workflowEntity))
                .collect(Collectors.toList());
    }

    public MembershipWorkflow findById(UUID id) {
        return toWorkflow.from(membershipWorkflowRepository.findById(id).get());
    }

    public void delete(UUID id) {
        try {
            membershipWorkflowRepository.delete(membershipWorkflowRepository.findById(id).get());
        } catch (WorkFlowNotDeleted e) {
            throw e;
        }
    }

    public void modifyUserStage(UUID id, Stage stage) {
        var workflow = membershipWorkflowRepository.findById(id);
        workflow.get().setStage(stage);
        membershipWorkflowRepository.save(workflow.get());
    }

    public String getStage(UUID id) {
        var userWorkflow = findById(id);
        var stage = userWorkflow.getStage();
        switch (stage) {
            case regulation:
                if (checkRegulated(userWorkflow.getEmail())) {
                    modifyUserStage(id, Stage.payment);
                    return getStage(id);
                }
            case payment:
                if (checkPayment(id)) {
                    var member = memberService.save(toMemberEntity.from(userWorkflow));
                    if(member!=null) modifyUserStage(id, Stage.registration);
                    return getStage(id);
                }
            case registration:
                if (checkRegistered(userWorkflow.getEmail())) {
                    delete(userWorkflow.getId());
                    return "Your are registered you can login to your account";
                }
        }
        return String.format("Please pass to %s", userWorkflow.getProfession().toString());
    }

    public Boolean checkRegulated(String email) {
        return regulationService.checkRegulation(email);
    }

    public Boolean checkPayment(UUID id) {
        return true;
    }

    public Boolean checkRegistered(String email) {
        return memberService.existsByEmail(email);
    }

    private String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
