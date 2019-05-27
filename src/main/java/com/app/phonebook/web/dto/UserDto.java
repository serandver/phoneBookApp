package com.app.phonebook.web.dto;

import com.app.phonebook.validation.PasswordMatches;
import com.app.phonebook.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @AssertTrue(message="{error.terms}")
    private Boolean terms;
}
