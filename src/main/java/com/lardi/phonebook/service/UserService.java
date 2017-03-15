package com.lardi.phonebook.service;

import com.lardi.phonebook.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getUserById(long id);
    User editUser (User user);
    List<User> getAll();
}
