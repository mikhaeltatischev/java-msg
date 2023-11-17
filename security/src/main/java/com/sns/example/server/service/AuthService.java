package com.sns.example.server.service;

import com.sns.example.server.dto.JwtRequest;
import com.sns.example.server.dto.JwtResponse;
import com.sns.example.server.security.JwtAuthentication;

import javax.security.auth.message.AuthException;

public interface AuthService {

    JwtResponse login(JwtRequest authRequest) throws AuthException;

    JwtResponse getAccessToken(String refreshToken) throws AuthException;

    JwtResponse refresh(String refreshToken) throws AuthException;

    JwtAuthentication getAuthInfo() throws AuthException;

}