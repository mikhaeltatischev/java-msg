package com.sns.example.server.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthException extends RuntimeException {

    private static final String MESSAGE = "Username or password is invalid";

    public AuthException() {
        super(MESSAGE);
        log.info(MESSAGE);
    }

}