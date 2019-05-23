package com.app.phonebook.web.dto;

import com.app.phonebook.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ContactDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String patronymic;

    @NotNull
    @NotEmpty
    private String mobilePhoneNumber;

    @NotNull
    @NotEmpty
    private String homePhoneNumber;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}