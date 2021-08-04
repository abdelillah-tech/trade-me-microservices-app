package com.example.tradememarket.models.Workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ProjectWorkflow {
    private UUID id;
    private String userEmail;
    private String name;
    private Stage stage;
}
