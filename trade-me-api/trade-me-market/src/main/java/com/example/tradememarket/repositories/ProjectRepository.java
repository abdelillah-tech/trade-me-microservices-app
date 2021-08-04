package com.example.tradememarket.repositories;

import com.example.tradememarket.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    List<ProjectEntity> findAllByUserEmail(String userEmail);
    Boolean existsByName(String name);
}
