package com.app.phonebook.service;

import com.app.phonebook.model.User;
import com.app.phonebook.web.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User addUser(UserDto userDto);
    Optional<User> getUserByUserId(long userId);
    User findByEmail(String email);
    void editUser (long userId, User user);
    void deleteUser(long userId);
}
