package com.example.tradememarket.utils.mappers;

import com.example.tradememarket.entities.ProjectEntity;
import com.example.tradememarket.models.ProjectRegisterRequestBody;
import org.springframework.stereotype.Component;

@Component
public class ProjectEntityMapper {
    public ProjectEntity from(ProjectRegisterRequestBody body) {
        var tradesmanEntity = new ProjectEntity();
        tradesmanEntity.setName(body.getName());
        tradesmanEntity.setUserEmail(body.getUserEmail());
        return tradesmanEntity;
    }
}
