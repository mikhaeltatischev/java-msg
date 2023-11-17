package com.sns.example.server.service;

import com.sns.example.server.dto.NewUser;
import com.sns.example.server.model.User;
import lombok.NonNull;

public interface UserService {

    User registration(NewUser user);

    User getByLogin(@NonNull String login);

}