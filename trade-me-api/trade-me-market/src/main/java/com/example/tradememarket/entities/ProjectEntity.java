package com.example.tradememarket.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String userEmail;

    private String name;

}
