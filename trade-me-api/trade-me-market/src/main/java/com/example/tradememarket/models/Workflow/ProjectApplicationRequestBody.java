package com.example.tradememarket.models.Workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectApplicationRequestBody {
    private String userEmail;
    private String name;
}
