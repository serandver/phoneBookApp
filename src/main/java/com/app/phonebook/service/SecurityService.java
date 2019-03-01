package com.app.phonebook.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

    String validatePasswordResetToken(long id, String token);
}
