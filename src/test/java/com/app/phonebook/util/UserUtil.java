package com.app.phonebook.util;

import com.app.phonebook.model.Role;
import com.app.phonebook.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserUtil {
    public static User createUser() {
        Role userRole = new Role("USER");
        Set<Role> userRoles = new HashSet();
        userRoles.add(userRole);

        User user = new User();
        user.setUsername("ivanLogin");
        user.setPassword("1234");
        user.setRoles(userRoles);
        return user;
    }
}
