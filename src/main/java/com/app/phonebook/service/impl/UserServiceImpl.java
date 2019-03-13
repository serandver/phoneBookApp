package com.app.phonebook.service.impl;

import com.app.phonebook.repository.RoleRepository;
import com.app.phonebook.service.UserService;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User addUser(User user) {
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUserId(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void editUser(long userId, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
