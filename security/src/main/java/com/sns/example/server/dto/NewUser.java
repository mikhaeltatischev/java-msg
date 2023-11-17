package com.sns.example.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
}