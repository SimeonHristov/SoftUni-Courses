package com.example.structure.service;

import com.example.structure.model.dto.UserLoginDto;
import com.example.structure.model.dto.UserRegisterDto;
import org.springframework.stereotype.Service;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);
}
