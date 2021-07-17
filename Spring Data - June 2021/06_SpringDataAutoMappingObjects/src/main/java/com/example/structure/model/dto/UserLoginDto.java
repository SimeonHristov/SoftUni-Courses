package com.example.structure.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserLoginDto {

    private String email;

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "[A-Za-z\\d]{6,}",
            message = "Enter valid password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String password;
}
