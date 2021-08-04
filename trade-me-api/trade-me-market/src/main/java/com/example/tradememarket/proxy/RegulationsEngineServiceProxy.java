package com.example.tradememarket.proxy;

import com.example.tradememarket.models.ProjectRegulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("regulations-engine")
public interface RegulationsEngineServiceProxy {
    @PostMapping("/project-regulation/create-member-regulation")
    Boolean createMemberRegulation(@RequestBody String email);

    @GetMapping("/project-regulation/check-member-regulation")
    Boolean checkMemberRegulation(@RequestBody String email);

    @PutMapping("/project-regulation/set-member-regulation")
    Boolean setMemberRegulation(@RequestBody ProjectRegulation regulation);
}
