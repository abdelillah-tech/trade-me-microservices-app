package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.MemberEntity;
import com.example.tradememembership.models.Workflow.MembershipWorkflow;
import org.springframework.stereotype.Component;

@Component
public class WorkflowToMemberEntity {
    public MemberEntity from(MembershipWorkflow membershipWorkflow) {
        var memberEntity = new  MemberEntity();
        memberEntity.setEmail(membershipWorkflow.getEmail());
        memberEntity.setFirstName(membershipWorkflow.getFirstName());
        memberEntity.setLastName(membershipWorkflow.getLastName());
        memberEntity.setPassword(membershipWorkflow.getPassword());
        memberEntity.setProfession(membershipWorkflow.getProfession());
        return memberEntity;
    }
}
