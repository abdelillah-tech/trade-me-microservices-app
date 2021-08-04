package com.example.tradememarket.repositories;

import com.example.tradememarket.entities.ProjectWorkflowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectWorkflowRepository extends JpaRepository<ProjectWorkflowEntity, UUID> {
    ProjectWorkflowEntity findByName(String email);
    Boolean existsByName(String name);
}
