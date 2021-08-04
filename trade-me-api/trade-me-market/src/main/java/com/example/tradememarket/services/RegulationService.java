package com.example.tradememarket.services;

import com.example.tradememarket.proxy.RegulationsEngineServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegulationService {

    @Autowired
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
