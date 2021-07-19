package com.example.regulationsengine.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class ProjectRegulationEntity {
    @Id
    @GeneratedValue
    private UUID ID;

    private Boolean licence;

    private Boolean contract;

    private Boolean authorisation;
}
