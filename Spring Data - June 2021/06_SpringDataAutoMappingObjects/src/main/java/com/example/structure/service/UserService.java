package com.example.structure.service;

import com.example.structure.model.dto.UserLoginDto;
import com.example.structure.model.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}