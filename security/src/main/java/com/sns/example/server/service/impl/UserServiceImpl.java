package com.sns.example.server.service.impl;

import com.sns.example.server.dto.NewUser;
import com.sns.example.server.dto.UserDto;
import com.sns.example.server.exception.UserLoginExistsException;
import com.sns.example.server.exception.UserNotFoundException;
import com.sns.example.server.model.User;
import com.sns.example.server.repository.UserRepository;
import com.sns.example.server.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sns.example.server.model.UserMapper.toUser;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDto registration(NewUser user) {
        checkUserLogin(user.getLogin());
        User savedUser = repository.save(toUser(user));

        log.info("User: " + savedUser + " saved");

        return new UserDto(user.getFirstName(), user.getLastName());
    }

    @Override
    public User getByLogin(@NonNull String login) {
        return repository.findUserByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    private void checkUserLogin(String login) {
        if (repository.findUserByLogin(login).isPresent()) {
            throw new UserLoginExistsException(login);
        }
    }

}