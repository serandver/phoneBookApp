package com.app.phonebook.service.impl;

import com.app.phonebook.dto.UserDto;
import com.app.phonebook.exceptions.EmailExistsException;
import com.app.phonebook.model.PasswordResetToken;
import com.app.phonebook.model.VerificationToken;
import com.app.phonebook.repository.PasswordResetTokenRepository;
import com.app.phonebook.repository.VerificationTokenRepository;
import com.app.phonebook.service.UserService;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    final static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    private MessageSource messages;

    @Autowired
    private Environment env;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException {
        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " +  userDto.getEmail());
        }
        User user = convertToEntity(userDto);
        List<String> defaultUserRoles = Arrays.asList("USER");
        user.setRoles(defaultUserRoles);
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    private User convertToEntity(UserDto userDto) {
        User user = null;
        try {
            user = modelMapper.map(userDto, User.class);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        } catch (Exception e) {
            LOGGER.error("UserDto can not be parsed, " + userDto);
        }
        return user;
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
                .toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public Optional<User> getUserByUserId(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void editUser(long userId, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        userRepository.delete(user);
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }

    private SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?id=" + user.getUserId() + "&token=" + token;
        String message = messages.getMessage("message.resetPassword", null, locale);
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
