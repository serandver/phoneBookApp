package com.lardi.phonebook.util;

import com.lardi.phonebook.entity.User;

public class UserUtil {
    public static User createUser() {
        User user = new User();
        user.setUserName("ivanLogin");
        user.setPassword("1234");
        user.setFio("Ivan Ivanovych Ivanov");
        return user;
    }
}
