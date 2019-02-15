package com.app.phonebook.service.impl;

import com.app.phonebook.repository.ContactRepository;
import com.app.phonebook.model.Contact;
import com.app.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts(long userId) {
        List<Contact> contactList = new ArrayList<>();
        contactRepository.findAll().forEach(contactList::add);
        return contactList;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(long contactId) {
        return contactRepository.findById(contactId);
    }

    @Override
    public Contact editContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

}
