package com.app.phonebook.web.controller;


import com.app.phonebook.model.Contact;
import com.app.phonebook.model.User;
import com.app.phonebook.service.ContactService;
import com.app.phonebook.service.UserService;
import com.app.phonebook.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/contacts")
    public List<Contact> getAllContacts(@PathVariable long userId) {
        return contactService.getAllContacts(userId);
    }

    @GetMapping("/users/{userId}/contacts/{contactId}")
    public Contact getContact (@PathVariable long contactId) {
        Optional<Contact> optionalContact = contactService.getContactById(contactId);
        Contact contact = new Contact();
        if (optionalContact.isPresent()) {
            contact = optionalContact.get();
        }
        return contact;
    }

    @PostMapping(value = "/users/{userId}/contacts")
    public Contact addContact (@RequestBody ContactDto contactDto, @PathVariable long userId) {
        return contactService.addContact(contactDto, userId);
    }

    @PutMapping(value = "/users/{userId}/contacts/{contactId}")
    public Contact updateContact (@RequestBody Contact contact, @PathVariable long userId, @PathVariable long contactId) {
        Optional<User> optionalUser = userService.getUserByUserId(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            contact.setUser(user);
        }
        return contactService.editContact(contact);
    }

    @DeleteMapping(value = "/users/{userId}/contacts/{contactId}")
    public void deleteContact (@PathVariable long contactId) {
        contactService.deleteContact(contactId);
    }
}
