package com.sns.example.server.controller;

import com.sns.example.server.dto.NewUser;
import com.sns.example.server.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;
    private final PasswordEncoder encoder;

    @PostMapping
    public ResponseEntity<Object> registration(@RequestBody NewUser user) {
        return service.registration(encode(user));
    }

    private NewUser encode(NewUser user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return user;
    }

}