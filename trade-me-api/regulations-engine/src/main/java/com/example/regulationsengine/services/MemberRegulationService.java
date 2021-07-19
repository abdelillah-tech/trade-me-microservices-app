package com.example.regulationsengine.services;

import com.example.regulationsengine.entities.MemberRegulationEntity;
import com.example.regulationsengine.models.MemberRegulation;
import com.example.regulationsengine.models.SetMemberRegulationRequestBody;
import com.example.regulationsengine.repositories.MemberRegulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberRegulationService {

    private final MemberRegulationRepository memberRegulationRepository;

    public Boolean save(String email) {
        var createdMemberRegulation = memberRegulationRepository.save(buildMemberRegulation(email));
        return createdMemberRegulation.getId() != null;
    }

    public Boolean checkRegulation(String email) {
        var memberRegulationEntity = findByEmail(email);
        return memberRegulationEntity.getLicence()
                && memberRegulationEntity.getWorkId();
    }

    public Boolean setRegulation(MemberRegulation regulation) {
        var memberRegulationEntity = findByEmail(regulation.getEmail());
        memberRegulationEntity.setWorkId(regulation.getWorkId());
        memberRegulationEntity.setLicence(regulation.getLicence());
        var regulationInserted = memberRegulationRepository.save(memberRegulationEntity);
        return regulationInserted.getId() != null;
    }

    public MemberRegulationEntity findByEmail(String email) {
        return memberRegulationRepository.findMemberRegulationEntityByEmail(email);
    }

    private MemberRegulationEntity buildMemberRegulation(String email) {
        var memberRegulationEntity = new MemberRegulationEntity();
        memberRegulationEntity.setEmail(email);
        memberRegulationEntity.setLicence(false);
        memberRegulationEntity.setWorkId(false);
        return memberRegulationEntity;
    }
}
