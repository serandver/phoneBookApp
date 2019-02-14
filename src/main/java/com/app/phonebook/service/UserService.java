package com.app.phonebook.service;

import com.app.phonebook.dto.UserDto;
import com.app.phonebook.exceptions.EmailExistsException;
import com.app.phonebook.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerNewUserAccount(UserDto userDto) throws EmailExistsException;
    User getUserByUserId(long userId);
    void editUser (long userId, User user);
    void deleteUser(long userId);
}
