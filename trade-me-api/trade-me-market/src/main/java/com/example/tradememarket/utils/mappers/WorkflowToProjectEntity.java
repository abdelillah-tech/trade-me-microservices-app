package com.example.tradememarket.utils.mappers;

import com.example.tradememarket.entities.ProjectEntity;
import com.example.tradememarket.models.Workflow.ProjectWorkflow;
import org.springframework.stereotype.Component;

@Component
public class WorkflowToProjectEntity {
    public ProjectEntity from(ProjectWorkflow projectWorkflow) {
        var projectEntity = new  ProjectEntity();
        projectEntity.setUserEmail(projectWorkflow.getUserEmail());
        projectEntity.setName(projectWorkflow.getName());
        return projectEntity;
    }
}
