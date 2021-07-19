package com.example.tradememembership.controllers;

import com.example.tradememembership.models.Payment.PaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @PostMapping
    public String pay(@RequestBody PaymentRequest request) {
        return "{\"transactionId\": \"77412\"}";
    }
}
