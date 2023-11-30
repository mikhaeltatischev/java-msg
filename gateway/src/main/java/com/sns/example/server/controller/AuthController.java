package com.sns.example.server.controller;

import com.sns.example.server.dto.AuthRequest;
import com.sns.example.server.dto.JwtResponse;
import com.sns.example.server.dto.RefreshJwtRequest;
import com.sns.example.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody AuthRequest request, HttpServletResponse response) {
        JwtResponse jwtResponse = service.login(request);

        Cookie cookie = new Cookie("refreshToken", jwtResponse.getRefreshToken());
        response.addCookie(cookie);

        return jwtResponse;
    }

    @PostMapping("/token")
    public JwtResponse getNewAccessToken(HttpServletRequest request) {
        return service.getNewAccessToken(new RefreshJwtRequest(request.getCookies()[0].getValue()));
    }

    @PostMapping("/refresh")
    public JwtResponse getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        return service.getNewRefreshToken(request);
    }

}