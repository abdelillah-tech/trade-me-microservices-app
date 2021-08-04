package com.example.tradememarket.services;

import com.example.tradememarket.entities.ProjectEntity;
import com.example.tradememarket.models.Project;
import com.example.tradememarket.repositories.ProjectRepository;
import com.example.tradememarket.utils.ProjectNotFoundException;
import com.example.tradememarket.utils.mappers.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectMapper toProject;

    private final ProjectRepository projectRepository;

    public Project save(ProjectEntity entity) {
        var tradesmanEntity = entity;
        var projectEntityInserted = projectRepository.save(tradesmanEntity);
        return toProject.from(projectEntityInserted);
    }

    public Project findOneById(UUID id) {
        var optionalProject = projectRepository.findById(id);

        if (optionalProject.isEmpty()) {
            throw new ProjectNotFoundException();
        }

        return toProject.from(optionalProject.get());
    }

    public Boolean existsById(UUID id) {
        return projectRepository.existsById(id);
    }

    public Boolean existsByName(String name) {
        return projectRepository.existsByName(name);
    }

    public List<Project> findByEmail(String email) {
        var optionalProjectList = projectRepository.findAllByUserEmail(email);
        if (optionalProjectList.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        var projectList = optionalProjectList.stream().map(project -> toProject.from(project)).collect(Collectors.toList());
        return projectList;
    }

    public List<Project> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(project -> toProject.from(project))
                .collect(Collectors.toList());
    }
}
