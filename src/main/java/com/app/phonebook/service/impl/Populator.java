package com.app.phonebook.service.impl;

import com.app.phonebook.repository.ContactRepository;
import com.app.phonebook.model.Contact;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Populator {

    //    should be less than 10
    private static final int NUMBER_OF_CONTACTS = 5;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    public void init() {
        populateUsers();
//        populateContacts();
    }

    private void populateUsers() {

        User user = User.builder()
                .firstName("user")
                .lastName("user")
                .email("user@user.com")
                .password("111")
                .build();
        userRepository.save(user);

        User admin = User.builder()
                .firstName("admin")
                .lastName("admin")
                .email("admin@admin.com")
                .password("222")
                .build();
        userRepository.save(admin);
    }

    private void populateContacts() {
        User user = userRepository.findByEmail("testUser");
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

    public static int getNumberOfContacts() {
        return NUMBER_OF_CONTACTS;
    }
}
