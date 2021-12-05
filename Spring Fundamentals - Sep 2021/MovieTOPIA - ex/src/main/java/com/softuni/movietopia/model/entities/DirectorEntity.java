package com.softuni.movietopia.model.entities;

import com.google.gson.annotations.Expose;
import javax.persistence.Column;
import javax.persistence.Entity;
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

  @Override
  public String toString() {
    return "DirectorEntity{" +
        "name='" + name + '\'' +
        ", bio='" + bio + '\'' +
        '}';
  }
}
