package com.sns.example.server.service;

import com.sns.example.server.dto.AuthRequest;
import com.sns.example.server.dto.JwtResponse;
import com.sns.example.server.dto.RefreshJwtRequest;
import com.sns.example.server.model.JwtAuthentication;
import io.jsonwebtoken.Claims;
import lombok.NonNull;

public interface AuthService {

    boolean validateToken(String token);

    Claims getClaims(@NonNull String token);

    JwtAuthentication getAuthentication();

    JwtResponse login(AuthRequest request);

    JwtResponse getNewAccessToken(RefreshJwtRequest request);

    JwtResponse getNewRefreshToken(RefreshJwtRequest request);

}