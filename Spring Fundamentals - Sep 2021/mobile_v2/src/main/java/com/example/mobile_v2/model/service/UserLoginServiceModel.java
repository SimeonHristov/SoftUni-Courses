package com.example.mobile_v2.model.service;

public class UserLoginServiceModel {

    private String userName;
    private String rawPassword;

    public String getUserName() {
        return userName;
    }

    public UserLoginServiceModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public UserLoginServiceModel setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
        return this;
    }
}
