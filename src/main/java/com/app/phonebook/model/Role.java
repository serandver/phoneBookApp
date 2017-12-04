package com.app.phonebook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles", cascade=CascadeType.ALL)
    private Set<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}