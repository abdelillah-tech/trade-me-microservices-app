package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.MemberEntity;
import com.example.tradememembership.models.Members.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member from(MemberEntity entity) {
        var member = new Member();
        member.setId(entity.getId());
        member.setEmail(entity.getEmail());
        member.setFirstName(entity.getFirstName());
        member.setLastName(entity.getLastName());
        member.setPassword(entity.getPassword());
        member.setProfession(entity.getProfession());
        return member;
    }
}
