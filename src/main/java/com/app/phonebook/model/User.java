package com.app.phonebook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
