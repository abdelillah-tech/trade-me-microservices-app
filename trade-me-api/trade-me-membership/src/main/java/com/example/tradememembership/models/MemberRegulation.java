package com.example.tradememembership.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberRegulation {
    private String email;
    private Boolean licence;
    private Boolean workId;
}
