package com.lardi.phonebook.repository;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findByUser (User user);
}
