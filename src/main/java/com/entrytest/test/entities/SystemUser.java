package com.entrytest.test.entities;


import com.entrytest.test.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {
    @NotNull(message = "must contain at least one letter in UPPER CASE and at least one number")
    private String login;

    @NotNull(message = "is required")
    private String name;

    @NotNull(message = "is required")
    private String password;

    @NotNull(message = "is required")
    private String matchingPassword;

}
