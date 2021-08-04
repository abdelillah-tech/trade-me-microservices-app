package com.example.tradememembership.proxy;

import com.example.tradememembership.models.MemberRegulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("regulations-engine")
public interface RegulationsEngineServiceProxy {
    @PostMapping("/member-regulation/create-member-regulation")
    Boolean createMemberRegulation(@RequestBody String email);

    @GetMapping("/member-regulation/check-member-regulation")
    Boolean checkMemberRegulation(@RequestBody String email);

    @PutMapping("/member-regulation/set-member-regulation")
    Boolean setMemberRegulation(@RequestBody MemberRegulation regulation);
}
