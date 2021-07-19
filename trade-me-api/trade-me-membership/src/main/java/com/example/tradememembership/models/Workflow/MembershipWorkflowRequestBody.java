package com.example.tradememembership.models.Workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class MembershipWorkflowRequestBody {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String profession;
}
