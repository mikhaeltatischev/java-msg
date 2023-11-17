package com.sns.example.server.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistrationException extends RuntimeException {

    private static final String MESSAGE = "Registration exception";

    public RegistrationException() {
        super(MESSAGE);
        log.info(MESSAGE);
    }

}