package com.example.tradememarket.utils.mappers;

import com.example.tradememarket.entities.ProjectWorkflowEntity;
import com.example.tradememarket.models.Workflow.ProjectWorkflow;
import org.springframework.stereotype.Component;

@Component
public class ProjectWorkflowMapper {
    public ProjectWorkflow from(ProjectWorkflowEntity entity) {
        var workflow = new ProjectWorkflow();
        workflow.setId(entity.getId());
        workflow.setUserEmail(entity.getUserEmail());
        workflow.setName(entity.getName());
        workflow.setStage(entity.getStage());
        return workflow;
    }
}
