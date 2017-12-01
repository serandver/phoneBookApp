package com.app.phonebook.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;
    private String userName;
    private String password;
    private String fio;

    @Enumerated(EnumType.STRING)
    private Role role;
}
