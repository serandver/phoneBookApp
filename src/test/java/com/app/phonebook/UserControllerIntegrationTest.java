package com.app.phonebook;

import com.app.phonebook.config.SecurityConfiguration;
import com.app.phonebook.model.User;
import com.app.phonebook.service.UserService;
import com.app.phonebook.service.impl.InitialDataLoader;
import com.app.phonebook.web.controller.ContactController;
import com.app.phonebook.web.controller.RegistrationController;
import com.app.phonebook.web.controller.UserController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private SecurityConfiguration securityConfiguration;

    @MockBean
    private InitialDataLoader initialDataLoader;

    @MockBean
    private BCryptPasswordEncoder encoder;

    @MockBean
    private ContactController contactController;

    @MockBean
    private RegistrationController registrationController;

    @InjectMocks
    private UserController userController;

    @Ignore
    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {

        User user = TestUtils.getUser();

        List<User> allUsers = Arrays.asList(user);

        given(userService.getAllUsers()).willReturn(allUsers);

        mvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is(user.getEmail())))
                .andExpect(jsonPath("$[0].firstName", is(user.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", is(user.getLastName())));
    }
}
