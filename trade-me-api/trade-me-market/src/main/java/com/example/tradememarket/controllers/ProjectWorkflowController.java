package com.example.tradememarket.controllers;

import com.example.tradememarket.models.Workflow.ProjectApplicationRequestBody;
import com.example.tradememarket.models.Workflow.ProjectWorkflow;
import com.example.tradememarket.models.Workflow.ProjectWorkflowRequestBody;
import com.example.tradememarket.services.ProjectService;
import com.example.tradememarket.services.ProjectWorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class ProjectWorkflowController {

    private final ProjectWorkflowService projectWorkflowService;
    private final ProjectService projectService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ProjectWorkflowRequestBody body) {
        if(projectWorkflowService.existByName(body.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        var membershipWorkflow = projectWorkflowService.save(body);
        return ResponseEntity.created(URI.create("/membership/register" + membershipWorkflow.getId().toString())).build();
    }

    @PostMapping("/application")
    public ResponseEntity<String> openApplication(@RequestBody ProjectApplicationRequestBody body) {
        if(projectService.existsByName(body.getName())) {
            return ResponseEntity.ok("Your already registered please login");
        }
        if(projectWorkflowService.existByName(body.getName())) {
            var entity = projectWorkflowService.findByName(body.getName());
            String stage = projectWorkflowService.getStage(entity.getId());
            return ResponseEntity.ok(stage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ProjectWorkflow>> getAll() {
        return ResponseEntity.ok(projectWorkflowService.findAll());
    }
}
