package com.lardi.phonebook.controller;

import com.lardi.phonebook.entity.User;
import com.lardi.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{userId}")
    public User getUser (@PathVariable long userId) {
        return userService.getUserByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser (@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
    public void updateUser (@RequestBody User user, @PathVariable long userId) {
        userService.editUser(userId, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser (@PathVariable long userId) {
        userService.deleteUser(userId);
    }

}
