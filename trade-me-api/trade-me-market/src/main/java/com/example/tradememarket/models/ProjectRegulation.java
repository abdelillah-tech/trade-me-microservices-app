package com.example.tradememarket.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectRegulation {
    private String email;
    private Boolean licence;
    private Boolean workId;
}
