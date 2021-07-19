package com.example.regulationsengine.repositories;

import com.example.regulationsengine.entities.MemberRegulationEntity;
import com.example.regulationsengine.models.MemberRegulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRegulationRepository extends JpaRepository<MemberRegulationEntity, UUID> {
    MemberRegulationEntity findMemberRegulationEntityByEmail(String email);
}
