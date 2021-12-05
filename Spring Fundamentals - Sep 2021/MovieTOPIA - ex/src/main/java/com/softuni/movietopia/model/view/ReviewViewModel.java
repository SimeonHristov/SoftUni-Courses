package com.softuni.movietopia.model.view;

import com.softuni.movietopia.model.entities.enums.Genre;

import java.time.LocalDateTime;

public class ReviewViewModel {

  private Long id;
  private String title;
  private Genre genre;
  private String content;
  private String author;
  private LocalDateTime createdOd;

  public Long getId() {
    return id;
  }

  public ReviewViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public ReviewViewModel setTitle(String title) {
    this.title = title;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public ReviewViewModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ReviewViewModel setContent(String content) {
    this.content = content;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public ReviewViewModel setAuthor(String author) {
    this.author = author;
    return this;
  }
  public LocalDateTime getCreatedOd() {
    return createdOd;
  }

  public ReviewViewModel setCreatedOd(LocalDateTime createdOd) {
    this.createdOd = createdOd;
    return this;
  }


}
