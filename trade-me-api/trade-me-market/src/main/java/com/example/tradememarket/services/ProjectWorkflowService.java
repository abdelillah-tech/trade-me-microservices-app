package com.example.tradememarket.services;

import com.example.tradememarket.entities.ProjectEntity;
import com.example.tradememarket.entities.ProjectWorkflowEntity;
import com.example.tradememarket.models.Workflow.ProjectWorkflow;
import com.example.tradememarket.models.Workflow.ProjectWorkflowRequestBody;
import com.example.tradememarket.models.Workflow.Stage;
import com.example.tradememarket.repositories.ProjectWorkflowRepository;
import com.example.tradememarket.utils.ProjectNotFoundException;
import com.example.tradememarket.utils.ProjectWorkflowNotFound;
import com.example.tradememarket.utils.WorkFlowNotDeleted;
import com.example.tradememarket.utils.mappers.ProjectWorkflowEntityMapper;
import com.example.tradememarket.utils.mappers.ProjectWorkflowMapper;
import com.example.tradememarket.utils.mappers.WorkflowToProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectWorkflowService {

    private final ProjectWorkflowRepository projectWorkflowRepository;
    private final ProjectWorkflowMapper toWorkflow;
    private final ProjectWorkflowEntityMapper toWorkflowEntity;
    private final ProjectService projectService;
    private final RegulationService regulationService;
    private final WorkflowToProjectEntity toProjectEntity;

    public ProjectWorkflow save(ProjectWorkflowRequestBody body) {
        var projectWorkflowEntity = toWorkflowEntity.from(body);
        projectWorkflowEntity.setStage(Stage.regulation);
        projectWorkflowEntity.setName(hashPassword(projectWorkflowEntity.getName()));

        var regulationInserted = regulationService.createRegulation(body.getUserEmail());
        if(!regulationInserted) {
            throw new RuntimeException("Your application can't be done for the moment");
        }
        var projectWorkflowEntityInserted = projectWorkflowRepository.save(projectWorkflowEntity);

        return toWorkflow.from(projectWorkflowEntityInserted);
    }

    public Boolean existByName(String name) {
        return projectWorkflowRepository.existsByName(name);
    }

    public ProjectWorkflowEntity findByName(String name) {
        return projectWorkflowRepository.findByName(name);
    }


    public ProjectWorkflow findById(UUID id) {
        if(projectWorkflowRepository.existsById(id)) {
            throw new ProjectWorkflowNotFound();
        }
        return toWorkflow.from(projectWorkflowRepository.findById(id).get());
    }

    public ProjectWorkflow findOneByUserEmail(String userEmail) {
        var optionalProjectWorkflow = findAll().stream()
                .filter(projectWorkflow -> projectWorkflow.getUserEmail().equals(userEmail))
                .findFirst();

        if (optionalProjectWorkflow.isEmpty()) {
            throw new ProjectNotFoundException();
        }

        return optionalProjectWorkflow.get();
    }

    public List<ProjectWorkflow> findAll() {
        return projectWorkflowRepository.findAll().stream()
                .map(workflowEntity -> toWorkflow.from(workflowEntity))
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        try {
            projectWorkflowRepository.delete(projectWorkflowRepository.findById(id).get());
        } catch (WorkFlowNotDeleted e) {
            throw e;
        }
    }

    public void modifyUserStage(UUID id, Stage stage) {
        var workflow = projectWorkflowRepository.findById(id);
        workflow.get().setStage(stage);
        projectWorkflowRepository.save(workflow.get());
    }

    public String getStage(UUID id) {
        var projectWorkflow = findById(id);
        var stage = projectWorkflow.getStage();
        switch (stage) {
            case regulation:
                if (checkRegulated(projectWorkflow.getUserEmail())) {
                    modifyUserStage(id, Stage.registration);
                    System.out.println(Stage.regulation);
                    return getStage(id);
                }
            case registration:
                if (checkRegistered(projectWorkflow.getId())) {
                    delete(projectWorkflow.getId());
                    System.out.println(Stage.registration);
                    return "Your are registered you can login to your account";
                }
        }
        return String.format("Please pass to %s", projectWorkflow.getStage().toString());
    }

    public Boolean checkRegulated(String email) {
        return regulationService.checkRegulation(email);
    }

    public Boolean checkRegistered(UUID id) {
        return projectService.existsById(id);
    }

    private String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
