package com.lardi.phonebook.service;

import com.lardi.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact);
    void delete(long id);
    Contact getContactById(long id);
    Contact editContact (Contact contact);
    List<Contact> getAll();
}

