package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.MembershipWorkflowEntity;
import com.example.tradememembership.models.Members.Profession;
import com.example.tradememembership.models.Workflow.MembershipWorkflowRequestBody;
import com.example.tradememembership.models.Workflow.Stage;
import org.springframework.stereotype.Component;

@Component
public class MembershipWorkflowEntityMapper {
    public MembershipWorkflowEntity from(MembershipWorkflowRequestBody body) {
        var workflowEntity = new MembershipWorkflowEntity();
        workflowEntity.setEmail(body.getEmail());
        workflowEntity.setFirstName(body.getFirstName());
        workflowEntity.setLastName(body.getLastName());
        workflowEntity.setPassword(body.getPassword());
        workflowEntity.setProfession(Profession.valueOf(body.getProfession()));
        return workflowEntity;
    }
}
