package com.softuni.movietopia.model.binding;

import com.softuni.movietopia.model.entities.enums.Genre;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewAddBindingModel {

  @NotEmpty
  @Size(min = 3, max = 20)
  private String title;
  @NotNull
  private Genre genre;
  @NotEmpty
  @Size(min = 5)
  private String content;

  public String getTitle() {
    return title;
  }

  public ReviewAddBindingModel setTitle(String title) {
    this.title = title;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public ReviewAddBindingModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ReviewAddBindingModel setContent(String content) {
    this.content = content;
    return this;
  }

  @Override
  public String toString() {
    return "ReviewAddBindingModel{" +
        "title='" + title + '\'' +
        ", genre=" + genre +
        ", content='" + content + '\'' +
        '}';
  }
}
