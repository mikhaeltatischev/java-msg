package com.sns.example.server.controller;

import com.sns.example.server.dto.NewUser;
import com.sns.example.server.model.User;
import com.sns.example.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> registration(@Valid @RequestBody NewUser user) {
        return ResponseEntity.ok(service.registration(user));
    }

}