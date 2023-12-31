package com.sns.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;

}