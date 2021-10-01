package com.example.pathfinderdemo.model.entity;

import com.example.pathfinderdemo.model.entity.enums.LevelEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private LevelEnum level;
    private Set<Role> roles;


    public User() {}

}
