package com.app.phonebook.repository;

import com.app.phonebook.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
