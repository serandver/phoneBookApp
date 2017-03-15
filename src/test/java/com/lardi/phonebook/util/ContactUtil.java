package com.lardi.phonebook.util;

import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.entity.User;

public class ContactUtil {
    public static Contact createContact() {
        Contact contact = new Contact();
        contact.setFirstName("Ivan");
        contact.setLastName("Ivanov");
        contact.setPatronymic("Ivanovych");
        contact.setAddress("Kyiv, Melrose pl.");
        contact.setEmail("vanka@gmail.com");
        contact.setHomePhoneNumber("0445554433");
        contact.setMobilePhoneNumber("0505554433");

        User user = UserUtil.createUser();
        contact.setUser(user);
        return contact;
    }
}
