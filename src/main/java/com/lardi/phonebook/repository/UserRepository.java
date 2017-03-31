package com.lardi.phonebook.repository;

import com.lardi.phonebook.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

}
