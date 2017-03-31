package com.lardi.phonebook.controller;


import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.entity.User;
import com.lardi.phonebook.service.ContactService;
import com.lardi.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @RequestMapping("/users/{userId}/contacts")
    public List<Contact> getAllContacts(@PathVariable long userId) {
        return contactService.getAllContacts(userId);
    }

    @RequestMapping("/users/{userId}/contacts/{contactId}")
    public Contact getContact (@PathVariable long contactId) {
        return contactService.getContactById(contactId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/contacts")
    public void addContact (@RequestBody Contact contact, @PathVariable long userId) {
        User user = userService.getUserByUserId(userId);
        contact.setUser(user);
        contactService.addContact(contact);
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/users/{userId}/contacts/{contactId}")
    public void updateContact (@RequestBody Contact contact, @PathVariable long userId, @PathVariable long contactId) {
        User user = userService.getUserByUserId(userId);
        contact.setUser(user);
        contactService.editContact(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/contacts/{contactId}")
    public void deleteContact (@PathVariable long contactId) {
        contactService.deleteContact(contactId);
    }
}
