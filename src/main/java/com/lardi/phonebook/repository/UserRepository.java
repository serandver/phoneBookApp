package com.lardi.phonebook.repository;

import com.lardi.phonebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

}
