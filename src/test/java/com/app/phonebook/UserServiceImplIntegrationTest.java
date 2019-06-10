package com.app.phonebook;

import com.app.phonebook.config.AppConfig;
import com.app.phonebook.model.User;
import com.app.phonebook.repository.RoleRepository;
import com.app.phonebook.repository.UserRepository;
import com.app.phonebook.service.UserService;
import com.app.phonebook.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
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
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        User user = TestUtils.getUser();

        Mockito.when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(user);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String email = "test@test.ua";
        User found = userService.findByEmail(email);

        assertEquals(found.getEmail(), email);
    }
}
