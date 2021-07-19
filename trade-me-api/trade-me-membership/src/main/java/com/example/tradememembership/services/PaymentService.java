package com.example.tradememembership.services;

import com.example.tradememembership.entities.PaymentEntity;
import com.example.tradememembership.models.Payment.Payment;
import com.example.tradememembership.repositories.PaymentRepository;
import com.example.tradememembership.utils.mappers.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper toPayment;

    public Payment save(PaymentEntity paymentEntity) {
        paymentEntity.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(paymentEntity);
        return toPayment.from(paymentEntity);
    }

    public Boolean executePayment(Long cardNumber) {
        if(cardNumber != null) return true;
        return false;
    }

    public Payment findOneById(UUID id) {
        var optionalPayment = paymentRepository.findById(id);
        return toPayment.from(optionalPayment.get());
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll()
                .stream()
                .map(payment -> toPayment.from(payment))
                .collect(Collectors.toList());
    }
}
