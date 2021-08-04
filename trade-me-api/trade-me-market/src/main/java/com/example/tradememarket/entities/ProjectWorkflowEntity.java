package com.example.tradememarket.entities;

import com.example.tradememarket.models.Workflow.Stage;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class ProjectWorkflowEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String userEmail;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Stage stage;
}
