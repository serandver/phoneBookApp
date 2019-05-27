package com.app.phonebook.service.impl;

import com.app.phonebook.model.User;
import com.app.phonebook.repository.ContactRepository;
import com.app.phonebook.model.Contact;
import com.app.phonebook.repository.UserRepository;
import com.app.phonebook.service.ContactService;
import com.app.phonebook.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Contact> getAllContacts(long userId) {
        List<Contact> contactList = new ArrayList<>();
        contactRepository.findAll().forEach(contactList::add);
        return contactList;
    }

    @Override
    public Contact addContact(ContactDto contactDto, long userId) {
        Contact contact = new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setPatronymic(contactDto.getPatronymic());
        contact.setHomePhoneNumber(contactDto.getHomePhoneNumber());
        contact.setMobilePhoneNumber(contactDto.getMobilePhoneNumber());
        contact.setAddress(contactDto.getAddress());
        contact.setEmail(contactDto.getEmail());

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            contact.setUser(user);
        }
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
    public void deleteContact(long contactId) {
        contactRepository.deleteById(contactId);
    }
}
