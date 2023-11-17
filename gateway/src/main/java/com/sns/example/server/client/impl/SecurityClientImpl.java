package com.sns.example.server.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sns.example.server.client.BaseClient;
import com.sns.example.server.client.SecurityClient;
import com.sns.example.server.dto.*;
import com.sns.example.server.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Slf4j
@Service
public final class SecurityClientImpl extends BaseClient implements SecurityClient {

    private final ObjectMapper mapper;

    private static final String REGISTRATION_URL = "/api/registration";
    private static final String LOGIN_URL = "/api/auth/login";
    private static final String TOKEN_URL = "/api/auth/token";
    private static final String REFRESH_URL = "/api/auth/refresh";

    @Autowired
    public SecurityClientImpl(@Value("${security.url}") String serverUrl, RestTemplateBuilder builder, ObjectMapper mapper) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
        this.mapper = mapper;
    }

    @Override
    public JwtResponse login(AuthRequest jwtRequest) {
        ResponseEntity<Object> response = post(LOGIN_URL, jwtRequest);
        log.info("Send request to " + LOGIN_URL);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new AuthException();
        }

        return mapper.convertValue(response.getBody(), JwtResponse.class);
    }

    @Override
    public ResponseEntity<Object> registration(NewUser user) {
        ResponseEntity<Object> response = post(REGISTRATION_URL, user);
        log.info("Send request to " + REGISTRATION_URL);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }

        return response;
    }

    @Override
    public JwtResponse getNewAccessToken(RefreshJwtRequest request) {
        ResponseEntity<Object> response = post(TOKEN_URL, request);
        return mapper.convertValue(response.getBody(), JwtResponse.class);
    }

    @Override
    public JwtResponse getNewRefreshToken(RefreshJwtRequest request) {
        ResponseEntity<Object> response = post(REFRESH_URL, request);
        return mapper.convertValue(response.getBody(), JwtResponse.class);
    }

}