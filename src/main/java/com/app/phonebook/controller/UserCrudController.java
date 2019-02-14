package com.app.phonebook.controller;

import com.app.phonebook.dto.UserDto;
import com.app.phonebook.exceptions.EmailExistsException;
import com.app.phonebook.model.User;
import com.app.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCrudController {

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
    public void addUser (@RequestBody UserDto userDto) throws EmailExistsException {
        userService.registerNewUserAccount(userDto);
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
