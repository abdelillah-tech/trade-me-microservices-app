package com.example.regulationsengine.services;

import com.example.regulationsengine.entities.ProjectRegulationEntity;
import com.example.regulationsengine.models.ProjectRegulation;
import com.example.regulationsengine.repositories.ProjectRegulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectRegulationService {
    private final ProjectRegulationRepository projectRegulationRepository;

    public Boolean save(UUID id) {
        var createdProjectRegulation = projectRegulationRepository.save(buildProjectRegulation(id));
        return createdProjectRegulation.getId() != null;
    }

    public Boolean checkRegulation(UUID id) {
        var projectRegulationEntity = findById(id);
        return projectRegulationEntity.getLicence()
                && projectRegulationEntity.getContract()
                && projectRegulationEntity.getAuthorisation();
    }

    public Boolean setRegulation(ProjectRegulation regulation) {
        var projectRegulationEntity = findById(regulation.getId());
        projectRegulationEntity.setContract(regulation.getContract());
        projectRegulationEntity.setLicence(regulation.getLicence());
        projectRegulationEntity.setAuthorisation(regulation.getAuthorisation());
        var regulationInserted = projectRegulationRepository.save(projectRegulationEntity);
        return regulationInserted.getId() != null;
    }

    public ProjectRegulationEntity findById(UUID id) {
        if(projectRegulationRepository.existsById(id)) {
            return projectRegulationRepository.findById(id).get();
        }
        return null;
    }

    private ProjectRegulationEntity buildProjectRegulation(UUID id) {
        var projectRegulationEntity = new ProjectRegulationEntity();
        projectRegulationEntity.setContract(false);
        projectRegulationEntity.setLicence(false);
        projectRegulationEntity.setAuthorisation(false);
        return projectRegulationEntity;
    }
}
