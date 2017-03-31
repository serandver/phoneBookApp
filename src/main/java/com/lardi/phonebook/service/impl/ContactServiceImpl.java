package com.lardi.phonebook.service.impl;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.repository.ContactRepository;
import com.lardi.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(long contactId) {
        return contactRepository.findOne(contactId);
    }

    @Override
    public void editContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(long contactId) {
        contactRepository.delete(contactId);
    }

}
