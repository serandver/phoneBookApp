package com.lardi.phonebook.service.impl;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.entity.User;
import com.lardi.phonebook.repository.ContactRepository;
import com.lardi.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Populator {

    //    should be less than 10
    private static final int NUMBER_OF_CONTACTS = 5;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    private void populateUsers() {
        User user = new User();
        user.setUserName("userLogin");
        user.setPassword("userPassword");
        user.setFio("userNameAndSurname");
        userRepository.save(user);
    }

    private void populateContacts() {
        User user = userRepository.findOne((long)1);;
        Contact contact;
        for (int i = 0; i< NUMBER_OF_CONTACTS; i++) {
            contact = new Contact();
            contact.setFirstName("Contact Name " + (i+1));
            contact.setLastName("Contact Surname " + (i+1));
            contact.setPatronymic("Patronymic " + (i+1));
            contact.setMobilePhoneNumber("Mobile phone +38(050)555-55-5" + (i+1));
            contact.setHomePhoneNumber("Home phone +38(044)222-22-2" + (i+1));
            contact.setEmail("email"+(i+1)+"@gmail.com");
            contact.setAddress("Address: Kyiv, Peremogy av."+(i+1)+" flat "+(i+1));
            contact.setUser(user);
            contactRepository.save(contact);
        }
    }

    public void init() {
        populateUsers();
        populateContacts();
    }

    public static int getNumberOfContacts() {
        return NUMBER_OF_CONTACTS;
    }
}
