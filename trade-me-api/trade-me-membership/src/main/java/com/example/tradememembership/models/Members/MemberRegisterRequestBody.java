package com.example.tradememembership.models.Members;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberRegisterRequestBody {
    private String firstName;
    private String lastName;
    private String email;
    private String profession;
    private String password;
    private Long cardNumber;
}
