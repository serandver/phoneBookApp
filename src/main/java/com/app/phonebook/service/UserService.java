package com.app.phonebook.service;

import com.app.phonebook.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    Optional<User> getUserByUserId(long userId);
    User findUserByEmail(String email);
    void editUser (long userId, User user);
    void deleteUser(long userId);
}
