package com.app.phonebook;

import com.app.phonebook.model.Role;
import com.app.phonebook.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TestUtils {
    static User getUser() {
        Set<Role> roles = new HashSet<>(Arrays.asList(getRole()));
        return User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("test@test.ua")
                .password("111")
                .roles(roles)
                .build();
    }

    static Role getRole() {
        return Role.builder()
                .name("ROLE_USER")
                .build();
    }
}
