package com.example.tradememarket.utils.mappers;

import com.example.tradememarket.entities.ProjectWorkflowEntity;
import com.example.tradememarket.models.Workflow.ProjectWorkflowRequestBody;
import org.springframework.stereotype.Component;

@Component
public class ProjectWorkflowEntityMapper {
    public ProjectWorkflowEntity from(ProjectWorkflowRequestBody body) {
        var workflowEntity = new ProjectWorkflowEntity();
        workflowEntity.setUserEmail(body.getUserEmail());
        workflowEntity.setName(body.getName());
        return workflowEntity;
    }
}
