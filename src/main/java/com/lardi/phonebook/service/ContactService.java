package com.lardi.phonebook.service;

import com.lardi.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts(long userId);
    Contact addContact(Contact contact);
    Contact getContactById(long contactId);
    void editContact (Contact contact);
    void deleteContact(long contactId);

}

