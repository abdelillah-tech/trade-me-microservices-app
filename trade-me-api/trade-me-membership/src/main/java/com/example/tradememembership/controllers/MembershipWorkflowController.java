package com.example.tradememembership.controllers;

import com.example.tradememembership.models.Workflow.MembershipApplicationRequestBody;
import com.example.tradememembership.models.Workflow.MembershipWorkflow;
import com.example.tradememembership.models.Workflow.MembershipWorkflowRequestBody;
import com.example.tradememembership.services.MemberService;
import com.example.tradememembership.services.MembershipWorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MembershipWorkflowController {

    private final MembershipWorkflowService membershipWorkflowService;
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MembershipWorkflowRequestBody body) {
        if(membershipWorkflowService.existByEmail(body.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        var membershipWorkflow = membershipWorkflowService.save(body);
        return ResponseEntity.created(URI.create("/membership/register" + membershipWorkflow.getId().toString())).build();
    }

    @PostMapping("/application")
    public ResponseEntity<String> openApplication(@RequestBody MembershipApplicationRequestBody body) {
        if(memberService.existsByEmail(body.getEmail())) {
            return ResponseEntity.ok("Your already registered please login");
        }
        if(membershipWorkflowService.existByEmail(body.getEmail())) {
            var entity = membershipWorkflowService.findByEmail(body.getEmail());
            String stage = membershipWorkflowService.getStage(entity.getId());
            return ResponseEntity.ok(stage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<MembershipWorkflow>> getAll() {
        return ResponseEntity.ok(membershipWorkflowService.findAll());
    }
}
