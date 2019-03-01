package com.app.phonebook.service.impl;

import com.app.phonebook.model.PasswordResetToken;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.PasswordResetTokenRepository;
import com.app.phonebook.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Calendar;

public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Override
    public String findLoggedInUsername() {
        return null;
    }

    @Override
    public void autologin(String username, String password) {

    }

    @Override
    public String validatePasswordResetToken(long id, String token) {
        PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
        if ((passToken == null) || (passToken.getUser().getUserId() != id)) {
            return "invalidToken";
        }

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate()
                .getTime() - cal.getTime()
                .getTime()) <= 0) {
            return "expired";
        }

        User user = passToken.getUser();
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user, null, Arrays.asList(
                new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return null;
    }
}
