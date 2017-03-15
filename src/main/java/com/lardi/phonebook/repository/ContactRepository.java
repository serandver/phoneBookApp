package com.lardi.phonebook.repository;

import com.lardi.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
