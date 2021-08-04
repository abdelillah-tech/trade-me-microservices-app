package com.example.regulationsengine.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ProjectRegulationRequest {
    private UUID projectId;
}
