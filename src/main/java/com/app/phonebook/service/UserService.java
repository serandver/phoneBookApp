package com.app.phonebook.service;

import com.app.phonebook.dto.UserDto;
import com.app.phonebook.exceptions.EmailExistsException;
import com.app.phonebook.model.User;
import com.app.phonebook.model.VerificationToken;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerNewUserAccount(UserDto userDto) throws EmailExistsException;
    User getUser(String verificationToken);
    void saveRegisteredUser(User user);
    void createVerificationToken(User user, String token);
    VerificationToken getVerificationToken(String VerificationToken);
    VerificationToken generateNewVerificationToken(String existingVerificationToken);
    User findUserByEmail(String email);
    void createPasswordResetTokenForUser(User user, String token);
    void changeUserPassword(User user, String password);
    List<User> getAllUsers();
    Optional<User> getUserByUserId(long userId);
    void editUser (long userId, User user);
    void deleteUser(UserDto userDto);
    boolean checkIfValidOldPassword(final User user, final String oldPassword);
}
