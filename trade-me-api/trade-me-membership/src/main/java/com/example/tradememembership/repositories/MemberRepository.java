package com.example.tradememembership.repositories;

import com.example.tradememembership.entities.MemberEntity;
import com.example.tradememembership.models.Members.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {
    Boolean existsByEmail(String email);
    List<MemberEntity> findByProfession(Profession profession);
}
