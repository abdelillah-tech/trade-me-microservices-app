package com.example.tradememembership.entities;

import com.example.tradememembership.models.Members.Profession;
import com.example.tradememembership.models.Workflow.Stage;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class MembershipWorkflowEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Profession profession;

    @Enumerated(EnumType.ORDINAL)
    private Stage stage;
}
