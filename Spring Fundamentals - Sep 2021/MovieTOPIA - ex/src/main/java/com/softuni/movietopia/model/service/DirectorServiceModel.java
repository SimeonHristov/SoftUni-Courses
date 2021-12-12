package com.softuni.movietopia.model.service;

public class DirectorServiceModel {

    private String name;
    private String bio;
    private String user;



    public DirectorServiceModel() {
    }

    public String getName() {
        return name;
    }

    public DirectorServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public DirectorServiceModel setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public String getUser() {
        return user;
    }

    public DirectorServiceModel setUser(String user) {
        this.user = user;
        return this;
    }
}
