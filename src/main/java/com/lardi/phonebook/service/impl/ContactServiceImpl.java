package com.lardi.phonebook.service.impl;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.entity.User;
import com.lardi.phonebook.repository.ContactRepository;
import com.lardi.phonebook.repository.UserRepository;
import com.lardi.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public Contact getContactById(long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact editContact(Long id, Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public void deleteContact(long id) {
        contactRepository.delete(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getUserContacts(Long userId) {
        User user = userRepository.findOne(userId);
        return contactRepository.findByUser(user);
    }
}
