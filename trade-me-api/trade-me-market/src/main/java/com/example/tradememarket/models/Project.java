package com.example.tradememarket.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Project {
    private UUID id;
    private String userEmail;
    private String name;
}
