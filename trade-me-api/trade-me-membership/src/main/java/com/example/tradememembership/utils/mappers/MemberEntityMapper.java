package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.MemberEntity;
import com.example.tradememembership.models.Members.Profession;
import com.example.tradememembership.models.Members.MemberRegisterRequestBody;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {
    public MemberEntity from(MemberRegisterRequestBody body) {
        var tradesmanEntity = new MemberEntity();
        tradesmanEntity.setFirstName(body.getFirstName());
        tradesmanEntity.setLastName(body.getLastName());
        tradesmanEntity.setProfession(Profession.valueOf(body.getProfession()));
        tradesmanEntity.setPassword(body.getPassword());
        tradesmanEntity.setEmail(body.getEmail());
        return tradesmanEntity;
    }
}
