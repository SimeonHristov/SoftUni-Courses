package com.softuni.movietopia.model.view;

public class DirectorViewModel {

  private Long id;
  private String name;

  public String getName() {
    return name;
  }

  public DirectorViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public Long getId() {
    return id;
  }

  public DirectorViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "DirectorViewModel{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
