package com.lardi.phonebook.service;

import com.lardi.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact);
    void deleteContact(long id);
    Contact getContactById(long id);
    Contact editContact (Long id, Contact contact);
    List<Contact> getAllContacts();
    List<Contact> getUserContacts(Long userId);

}

