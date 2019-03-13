package com.app.phonebook.repository;

import com.app.phonebook.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByUserId (Long id);
}
