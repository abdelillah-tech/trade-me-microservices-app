package com.example.regulationsengine.controllers;

import com.example.regulationsengine.models.ProjectRegulation;
import com.example.regulationsengine.models.ProjectRegulationRequest;
import com.example.regulationsengine.services.ProjectRegulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project-regulation")
public class ProjectRegulationController {
    private final ProjectRegulationService projectRegulationService;

    @PostMapping("/create-project-regulation")
    public Boolean createProjectRegulation(@RequestBody ProjectRegulationRequest project) {
        return projectRegulationService.save(project.getProjectId());
    }

    @GetMapping("/check-project-regulation/")
    public Boolean checkProjectRegulation(@RequestBody UUID id) {
        return projectRegulationService.checkRegulation(id);
    }

    @PutMapping("/set-project-regulation")
    public Boolean setProjectRegulation(@RequestBody ProjectRegulation regulation) {
        return projectRegulationService.setRegulation(regulation);
    }
}
