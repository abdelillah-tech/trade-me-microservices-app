package com.example.tradememembership.models.Members;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Member {
    private UUID id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Profession profession;
}
