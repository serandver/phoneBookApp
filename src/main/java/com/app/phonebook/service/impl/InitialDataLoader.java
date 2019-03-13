package com.app.phonebook.service.impl;

import com.app.phonebook.model.Role;
import com.app.phonebook.repository.ContactRepository;
import com.app.phonebook.model.Contact;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.RoleRepository;
import com.app.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    //    should be less than 10
    private static final int NUMBER_OF_CONTACTS = 5;
    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        populateUsers();
        populateContacts();
    }

    @Transactional
    private void populateUsers() {
        createRoleIfNotFound("ROLE_USER");
        createRoleIfNotFound("ROLE_ADMIN");

        User user = createUser();
        userRepository.save(user);

        User admin = createAdmin(user);
        userRepository.save(admin);
    }

    @Transactional
    private void createRoleIfNotFound(String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            role = new Role(roleName);
            roleRepository.save(role);
        }
    }

    @Transactional
    private User createUser() {
        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setEmail("user@test.com");
        user.setPassword("user");
        Set<Role> userRoles = new HashSet();
        Role userRole = roleRepository.findByName("ROLE_USER");
        userRoles.add(userRole);
        user.setRoles(userRoles);
        return user;
    }

    @Transactional
    private User createAdmin(User user) {
        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@test.com");
        admin.setPassword("admin");
        Set<Role> adminRoles = new HashSet();
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        adminRoles.add(adminRole);
        admin.setRoles(adminRoles);
        return admin;
    }

    @Transactional
    private void populateContacts() {
        User user = userRepository.findByEmail("user@test.com");
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
}
