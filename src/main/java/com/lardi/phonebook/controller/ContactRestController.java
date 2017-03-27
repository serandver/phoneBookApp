package com.lardi.phonebook.controller;


import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    private ContactServiceImpl contactService;

    @RequestMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping("/contacts/{id}")
    public Contact getContact(@PathVariable long id) {
        return contactService.getContactById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contacts")
    public void addContact (@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/contacts/{id}")
    public void updateContact (@RequestBody Contact contact, @PathVariable long id) {
        contactService.editContact(id, contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/contacts/{id}")
    public void deleteContact (@PathVariable long id) {
        contactService.deleteContact(id);
    }
}
