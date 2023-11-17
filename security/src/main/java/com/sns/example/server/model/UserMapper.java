package com.sns.example.server.model;

import com.sns.example.server.dto.NewUser;

public class UserMapper {

    public static User toUser(NewUser user) {
        return new User(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), Role.USER);
    }

}