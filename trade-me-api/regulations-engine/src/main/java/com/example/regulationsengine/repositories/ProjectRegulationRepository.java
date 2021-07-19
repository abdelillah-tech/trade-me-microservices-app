package com.example.regulationsengine.repositories;

import com.example.regulationsengine.entities.ProjectRegulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRegulationRepository extends JpaRepository<ProjectRegulationEntity, UUID> {
}
