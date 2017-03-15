package com.lardi.phonebook.service.impl;

import com.lardi.phonebook.entity.User;
import com.lardi.phonebook.repository.UserRepository;
import com.lardi.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public User getUserById(long id) {
        return repository.findOne(id);
    }

    @Override
    public User editUser(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
