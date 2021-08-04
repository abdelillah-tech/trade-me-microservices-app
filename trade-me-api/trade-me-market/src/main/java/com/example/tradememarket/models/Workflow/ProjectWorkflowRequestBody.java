package com.example.tradememarket.models.Workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectWorkflowRequestBody {
    private String userEmail;
    private String name;
}
