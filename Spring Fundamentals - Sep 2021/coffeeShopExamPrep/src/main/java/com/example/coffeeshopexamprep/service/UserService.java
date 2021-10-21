package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.entity.User;
import com.example.coffeeshopexamprep.model.serviceModels.UserServiceModel;
import com.example.coffeeshopexamprep.model.viewModels.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
