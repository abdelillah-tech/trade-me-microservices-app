package com.example.tradememembership.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "payments")
@RequiredArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="user_entity_id")
    private MemberEntity user;

    @Column(nullable = false)
    private Long cardNumber;

    @Column(nullable = false, unique = true)
    private LocalDateTime paymentDate;
}
