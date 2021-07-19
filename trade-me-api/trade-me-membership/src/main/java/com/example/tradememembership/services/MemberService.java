package com.example.tradememembership.services;

import com.example.tradememembership.entities.MemberEntity;
import com.example.tradememembership.entities.PaymentEntity;
import com.example.tradememembership.models.Members.Member;
import com.example.tradememembership.models.Members.MemberRegisterRequestBody;
import com.example.tradememembership.models.Members.Profession;
import com.example.tradememembership.models.Payment.Payment;
import com.example.tradememembership.repositories.MemberRepository;
import com.example.tradememembership.utils.PaymentFailed;
import com.example.tradememembership.utils.UserNotFoundException;
import com.example.tradememembership.utils.mappers.MemberEntityMapper;
import com.example.tradememembership.utils.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper toMember;

    private final MemberRepository memberRepository;

    public Member save(MemberEntity entity) {
        var tradesmanEntity = entity;
        var memberEntityInserted = memberRepository.save(tradesmanEntity);
        return toMember.from(memberEntityInserted);
    }

    public Member findOneById(UUID id) {
        var optionalTradesman = memberRepository.findById(id);

        if (optionalTradesman.isEmpty()) {
            throw new UserNotFoundException();
        }

        return toMember.from(optionalTradesman.get());
    }

    public Boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    public Member findOneByEmail(String email) {
        var optionalTradesman = findAll()
                .stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst();
        if (optionalTradesman.isEmpty()) {
            throw new UserNotFoundException();
        }
        return optionalTradesman.get();
    }

    public List<Member> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(member -> toMember.from(member))
                .collect(Collectors.toList());
    }

    public List<Member> findByProfession(Profession profession) {
        return memberRepository.findByProfession(profession)
                .stream()
                .map(member -> toMember.from(member))
                .collect(Collectors.toList());
    }
}
