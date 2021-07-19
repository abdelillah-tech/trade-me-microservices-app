package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.MembershipWorkflowEntity;
import com.example.tradememembership.models.Workflow.MembershipWorkflow;
import org.springframework.stereotype.Component;

@Component
public class MembershipWorkflowMapper {
    public MembershipWorkflow from(MembershipWorkflowEntity entity) {
        var workflow = new MembershipWorkflow();
        workflow.setId(entity.getId());
        workflow.setEmail(entity.getEmail());
        workflow.setFirstName(entity.getFirstName());
        workflow.setLastName(entity.getLastName());
        workflow.setPassword(entity.getPassword());
        workflow.setProfession(entity.getProfession());
        workflow.setStage(entity.getStage());
        return workflow;
    }
}
