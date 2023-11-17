package com.sns.example.server.service.impl;

import com.sns.example.server.client.SecurityClient;
import com.sns.example.server.dto.NewUser;
import com.sns.example.server.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class RegistrationServiceImpl implements RegistrationService {

    private final SecurityClient client;

    @Override
    public ResponseEntity<Object> registration(NewUser user) {
        return client.registration(user);
    }

}