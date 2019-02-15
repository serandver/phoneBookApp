package com.app.phonebook.util;

import com.app.phonebook.dto.UserDto;
import com.app.phonebook.model.User;
import com.app.phonebook.model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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

        UserDto userDto = UserUtil.createUser();
        User user = toEntity(userDto);
        contact.setUser(user);
        return contact;
    }

    private static User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
