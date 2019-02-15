package com.app.phonebook.service;

import com.app.phonebook.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAllContacts(long userId);
    Contact addContact(Contact contact);
    Optional<Contact> getContactById(long contactId);
    Contact editContact (Contact contact);
    void deleteContact(Contact contact);

}

