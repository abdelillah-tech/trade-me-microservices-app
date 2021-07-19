package com.example.tradememembership.controllers;

import com.example.tradememembership.models.Members.Member;
import com.example.tradememembership.models.Members.Profession;
import com.example.tradememembership.models.Payment.Payment;
import com.example.tradememembership.services.PaymentService;
import com.example.tradememembership.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{profession}")
    public ResponseEntity<List<Member>> getByProfession(@PathVariable String profession) {
        try {
            var memberProfession = Profession.valueOf(profession);
            return ResponseEntity.ok(memberService.findByProfession(memberProfession));
        } catch (RuntimeException e) {
            throw new RuntimeException("This profession doesn't exist");
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.findAll());
    }
}
