package com.example.regulationsengine.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ProjectRegulation {
    private UUID ID;
    private UUID projectId;
    private Boolean licence;
    private Boolean contract;
    private Boolean authorisation;
}