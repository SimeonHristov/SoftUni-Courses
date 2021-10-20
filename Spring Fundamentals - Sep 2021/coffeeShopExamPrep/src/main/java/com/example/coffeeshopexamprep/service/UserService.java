package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.entity.User;
import com.example.coffeeshopexamprep.model.serviceModels.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);
}
