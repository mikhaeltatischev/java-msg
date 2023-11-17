package com.sns.example.server.service;

import com.sns.example.server.dto.NewUser;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {

    ResponseEntity<Object> registration(NewUser user);

}