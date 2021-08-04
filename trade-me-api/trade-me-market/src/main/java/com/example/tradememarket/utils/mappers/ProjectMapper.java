package com.example.tradememarket.utils.mappers;

import com.example.tradememarket.entities.ProjectEntity;
import com.example.tradememarket.models.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project from(ProjectEntity entity) {
        var project = new Project();
        project.setId(entity.getId());
        project.setUserEmail(entity.getUserEmail());
        project.setName(entity.getName());
        return project;
    }
}
