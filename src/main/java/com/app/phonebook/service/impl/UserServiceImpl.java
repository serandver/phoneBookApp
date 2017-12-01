package com.app.phonebook.service.impl;

import com.app.phonebook.service.UserService;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserId(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void editUser(long userId, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}