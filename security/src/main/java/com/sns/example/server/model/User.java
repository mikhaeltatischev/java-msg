package com.sns.example.server.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "login")
    private String login;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private Role roles;

}