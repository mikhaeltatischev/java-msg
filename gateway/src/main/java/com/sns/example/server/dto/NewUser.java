package com.sns.example.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class NewUser {

    @NotBlank
    @Length(min = 2, max = 255)
    private String login;
    @NotBlank
    @Length(min = 2, max = 255)
    private String password;
    @NotBlank
    @Length(min = 2, max = 255)
    private String firstName;
    @NotBlank
    @Length(min = 2, max = 255)
    private String lastName;

    public NewUser(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}