package com.example.tradememembership.repositories;

import com.example.tradememembership.entities.MembershipWorkflowEntity;
import com.example.tradememembership.utils.MembershipWorkflowNotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MembershipWorkflowRepository extends JpaRepository<MembershipWorkflowEntity, UUID> {
    Boolean existsByEmail(String email);
    MembershipWorkflowEntity findByEmail(String email);
}
