package com.example.tradememarket.controllers;

import com.example.tradememarket.models.Project;
import com.example.tradememarket.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getByProfession(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(projectService.findOneById(id));
        } catch (RuntimeException e) {
            throw new RuntimeException("This profession doesn't exist");
        }
    }
}
