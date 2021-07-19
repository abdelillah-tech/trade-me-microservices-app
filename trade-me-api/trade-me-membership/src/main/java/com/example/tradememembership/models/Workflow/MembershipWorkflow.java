package com.example.tradememembership.models.Workflow;

import com.example.tradememembership.models.Members.Profession;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class MembershipWorkflow {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Profession profession;
    private Stage stage;
}
