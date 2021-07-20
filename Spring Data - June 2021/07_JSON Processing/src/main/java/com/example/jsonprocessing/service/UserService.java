package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.entity.User;
import com.example.jsonprocessing.repository.UserRepository;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();
}
