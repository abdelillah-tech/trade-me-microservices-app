package com.example.regulationsengine.controllers;

import com.example.regulationsengine.models.MemberRegulation;
import com.example.regulationsengine.services.MemberRegulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-regulation")
public class MemberRegulationController {

    private final MemberRegulationService memberRegulationService;

    @PostMapping("/create-member-regulation")
    public Boolean createMemberRegulation(@RequestBody String email) {
        return memberRegulationService.save(email);
    }

    @GetMapping("/check-member-regulation/")
    public Boolean checkMemberRegulation(@RequestBody String email) {
        return memberRegulationService.checkRegulation(email);
    }

    @PutMapping("/set-member-regulation")
    public Boolean setMemberRegulation(@RequestBody MemberRegulation regulation) {
        return memberRegulationService.setRegulation(regulation);
    }
}
