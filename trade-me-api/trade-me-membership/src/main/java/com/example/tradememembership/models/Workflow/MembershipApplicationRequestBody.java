package com.example.tradememembership.models.Workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MembershipApplicationRequestBody {
    private String email;
    private String password;
}
