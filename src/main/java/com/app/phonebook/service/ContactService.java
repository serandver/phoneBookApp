package com.app.phonebook.service;

import com.app.phonebook.model.Contact;
import com.app.phonebook.web.dto.ContactDto;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAllContacts(long userId);
    Contact addContact(ContactDto contactDto, long userId);
    Optional<Contact> getContactById(long contactId);
    Contact editContact (Contact contact);
    void deleteContact(long contactId);
}

