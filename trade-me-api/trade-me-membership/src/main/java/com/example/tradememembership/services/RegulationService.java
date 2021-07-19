package com.example.tradememembership.services;

import com.example.tradememembership.proxy.RegulationsEngineServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegulationService {

    private final RegulationsEngineServiceProxy regulationsEngineServiceProxy;

    public Boolean createRegulation(String email) {
        System.out.println(email);
        var response = regulationsEngineServiceProxy.createMemberRegulation(email);
        System.out.println(response);
        return response;
    }

    public Boolean checkRegulation(String email) {
        return regulationsEngineServiceProxy.checkMemberRegulation(email);
    }
}
