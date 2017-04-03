package com.lardi.phonebook.service;

import com.lardi.phonebook.config.TestDataBaseConfig;
import com.lardi.phonebook.util.ContactUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class ContactServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private ContactService contactService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveContact() throws Exception {
        contactService.addContact(ContactUtil.createContact());
    }
}
