package com.softuni.movietopia.model.service;

import com.softuni.movietopia.model.entities.enums.Genre;

public class ReviewServiceModel {

  private String title;
  private Genre genre;
  private String content;
  private String user;

  public String getTitle() {
    return title;
  }

  public ReviewServiceModel setTitle(String title) {
    this.title = title;
    return this;
  }


  public Genre getGenre() {
    return genre;
  }

  public ReviewServiceModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ReviewServiceModel setContent(String content) {
    this.content = content;
    return this;
  }

  public String getUser() {
    return user;
  }

  public ReviewServiceModel setUser(String user) {
    this.user = user;
    return this;
  }

  @Override
  public String toString() {
    return "ReviewServiceModel{" +
        "title='" + title + '\'' +
        ", genre=" + genre +
        ", content='" + content + '\'' +
        ", userName='" + user + '\'' +
        '}';
  }
}
