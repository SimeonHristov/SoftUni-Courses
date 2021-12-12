package com.softuni.movietopia.model.binding;

import javax.validation.constraints.NotNull;


public class DirectorAddBindingModel {


    @NotNull
    private String name;
    @NotNull
    private String bio;

    public String getName() {
        return name;
    }

    public DirectorAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public DirectorAddBindingModel setBio(String bio) {
        this.bio = bio;
        return this;
    }
}
