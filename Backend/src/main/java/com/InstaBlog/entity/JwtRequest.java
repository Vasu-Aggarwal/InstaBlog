package com.InstaBlog.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class JwtRequest {
    private String email;
    private String password;
}
