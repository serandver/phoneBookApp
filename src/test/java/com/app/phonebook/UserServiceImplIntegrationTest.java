package com.app.phonebook;

import com.app.phonebook.model.User;
import com.app.phonebook.repository.PasswordResetTokenRepository;
import com.app.phonebook.repository.UserRepository;
import com.app.phonebook.repository.VerificationTokenRepository;
import com.app.phonebook.service.UserService;
import com.app.phonebook.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private VerificationTokenRepository tokenRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Qualifier("messages")
    private MessageSource messages;

    @MockBean
    private PasswordResetTokenRepository passwordTokenRepository;

    @Before
    public void setUp() {
        User user = TestUtils.getUser();

        Mockito.when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(user);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String email = "test@test.ua";
        User found = userService.findUserByEmail(email);

        assertEquals(found.getEmail(), email);
    }
}
