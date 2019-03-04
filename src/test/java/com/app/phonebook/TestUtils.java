package com.app.phonebook;

import com.app.phonebook.model.User;

import java.util.Arrays;

public class TestUtils {
    public static User getUser() {
        return User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("test@test.ua")
                .password("111")
                .roles(Arrays.asList("USER"))
                .enabled(true)
                .build();
    }
}
