package com.app.phonebook.util;

import com.app.phonebook.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {


    public static UserDto createUser() {
        List<String> userRoles = new ArrayList<>();
        userRoles.add("USER");

        UserDto userDto = new UserDto();
        userDto.setFirstName("Ivan");
        userDto.setLastName("Ivanov");
        userDto.setPassword("1234");
        return userDto;
    }
}
