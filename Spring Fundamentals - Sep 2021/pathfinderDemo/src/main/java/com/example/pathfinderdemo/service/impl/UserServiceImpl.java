package com.example.pathfinderdemo.service.impl;

import com.example.pathfinderdemo.model.entity.User;
import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import com.example.pathfinderdemo.model.serviceModel.UserServiceModel;
import com.example.pathfinderdemo.repository.UserRepository;
import com.example.pathfinderdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }
}
