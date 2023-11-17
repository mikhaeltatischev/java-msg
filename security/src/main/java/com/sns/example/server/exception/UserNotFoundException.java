package com.sns.example.server.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "User with login: %s not found";

    public UserNotFoundException(String login) {
        super(String.format(MESSAGE, login));
        log.info(String.format(MESSAGE, login));
    }

}