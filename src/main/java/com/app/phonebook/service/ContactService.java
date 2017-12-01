package com.app.phonebook.service;

import com.app.phonebook.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts(long userId);
    Contact addContact(Contact contact);
    Contact getContactById(long contactId);
    Contact editContact (Contact contact);
    void deleteContact(long contactId);

}

