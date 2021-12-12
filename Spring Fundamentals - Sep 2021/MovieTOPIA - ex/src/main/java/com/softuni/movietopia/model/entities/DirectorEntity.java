package com.softuni.movietopia.model.entities;

import com.google.gson.annotations.Expose;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="directors")
public class DirectorEntity extends BaseEntity {

  @Expose
  @Column(nullable = false)
  private String name;
  @Expose
  @Column(nullable = false, columnDefinition = "TEXT")
  private String bio;


  @ManyToOne
  private UserEntity userEntity;

  public String getName() {
    return name;
  }

  public DirectorEntity setName(String name) {
    this.name = name;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public DirectorEntity setBio(String careerInformation) {
    this.bio = careerInformation;
    return this;
  }


  public UserEntity getUserEntity() {
    return userEntity;
  }

  public DirectorEntity setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }

  @Override
  public String toString() {
    return "DirectorEntity{" +
        "name='" + name + '\'' +
        ", bio='" + bio + '\'' +
        '}';
  }
}
