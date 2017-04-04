package com.lardi.phonebook.service;

import com.lardi.phonebook.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User getUserByUserId(long userId);
    void editUser (long userId, User user);
    void deleteUser(long userId);
}
