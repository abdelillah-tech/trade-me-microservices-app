package com.example.tradememarket.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectRegisterRequestBody {
    private String userEmail;
    private String name;
}
