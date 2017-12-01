package com.app.phonebook.service;

import com.app.phonebook.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User getUserByUserId(long userId);
    void editUser (long userId, User user);
    void deleteUser(long userId);
    User findByUserName(String userName);
}