package com.lardi.phonebook.service.impl;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.repository.ContactRepository;
import com.lardi.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact addContact(Contact contact) {
        return repository.saveAndFlush(contact);
    }

    @Override
    public Contact getContactById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Contact editContact(Contact contact) {
        return repository.saveAndFlush(contact);
    }

    @Override
    public void deleteContact(long id) {
        repository.delete(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }
}
