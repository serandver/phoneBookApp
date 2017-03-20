package com.lardi.phonebook.service;

public interface SecurityService {
    String findLoggedInUserById();

    void autologin(String login, String password);
}
