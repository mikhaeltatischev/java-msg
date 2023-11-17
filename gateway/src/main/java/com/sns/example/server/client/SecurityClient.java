package com.sns.example.server.client;

import com.sns.example.server.dto.AuthRequest;
import com.sns.example.server.dto.JwtResponse;
import com.sns.example.server.dto.NewUser;
import com.sns.example.server.dto.RefreshJwtRequest;
import org.springframework.http.ResponseEntity;

public interface SecurityClient {

    JwtResponse login(AuthRequest jwtRequest);

    ResponseEntity<Object> registration(NewUser user);

    JwtResponse getNewAccessToken(RefreshJwtRequest request);

    JwtResponse getNewRefreshToken(RefreshJwtRequest request);

}