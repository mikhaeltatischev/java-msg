package com.sns.example.server.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLoginExistsException extends RuntimeException {

    private static final String MESSAGE = "User with login: %s already exists";

    public UserLoginExistsException(String login) {
        super(String.format(MESSAGE, login));
        log.info(String.format(MESSAGE, login));
    }

}