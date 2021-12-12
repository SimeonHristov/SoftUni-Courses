package com.softuni.movietopia.service;

import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.service.UserRegistrationServiceModel;

import java.util.List;

public interface UserService {

  void seedUsers();

  void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

  boolean userNameExists(String username);

    UserEntity findByName(String username);

    UserEntity findById(Long id);

}
