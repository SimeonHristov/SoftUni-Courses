package com.example.coffeeshopexamprep.repository;

import com.example.coffeeshopexamprep.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findAllByUsernameAndPassword(String username, String password);
}
