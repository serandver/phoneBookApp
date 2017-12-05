package com.app.phonebook.service.impl;

import com.app.phonebook.model.Role;
import com.app.phonebook.repository.RoleRepository;
import com.app.phonebook.service.UserService;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User createNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        setDefaultUserRole(user);
        return userRepository.save(user);
    }

    private void setDefaultUserRole(User user) {
        Set<Role> defaultRolesForNewUser = new HashSet<>();
        Role userRole = roleRepository.findByName("USER");
        defaultRolesForNewUser.add(userRole);
        user.setRoles(defaultRolesForNewUser);
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
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}
