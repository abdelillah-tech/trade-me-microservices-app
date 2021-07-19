package com.example.tradememembership.utils.mappers;

import com.example.tradememembership.entities.PaymentEntity;
import com.example.tradememembership.models.Payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment from(PaymentEntity paymentEntity) {
        var payment = new Payment();
        payment.setId(paymentEntity.getId());
        return payment;
    }
}
