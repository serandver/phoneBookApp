package com.lardi.phonebook.repository;

import com.lardi.phonebook.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByUserUserId (Long userId);
}
