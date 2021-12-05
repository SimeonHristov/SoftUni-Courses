package com.softuni.movietopia.model.binding;

import com.softuni.movietopia.model.entities.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieAddBindingModel {

  @Size(min = 5, max = 20)
  private String name;
  @Size(min = 5)
  private String poster;
  private String trailer;
  @Size(min = 5)
  private String description;
  @DecimalMin("0")
  private BigDecimal rating;
  @NotNull
  private Genre genre;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate releaseDate;
  @NotNull
  private String director;



  public String getName() {
    return name;
  }

  public MovieAddBindingModel setName(String name) {
    this.name = name;
    return this;
  }


  public String getPoster() {
    return poster;
  }

  public MovieAddBindingModel setPoster(String poster) {
    this.poster = poster;
    return this;
  }

  public String getTrailer() {
    return trailer;
  }

  public MovieAddBindingModel setTrailer(String trailer) {
    this.trailer = trailer;
    return this;
  }


  public String getDescription() {
    return description;
  }

  public MovieAddBindingModel setDescription(String description) {
    this.description = description;
    return this;
  }


  public BigDecimal getRating() {
    return rating;
  }

  public MovieAddBindingModel setRating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }


  public Genre getGenre() {
    return genre;
  }

  public MovieAddBindingModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }


  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public MovieAddBindingModel setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public String getDirector() {
    return director;
  }

  public MovieAddBindingModel setDirector(String director) {
    this.director = director;
    return this;
  }

  @Override
  public String toString() {
    return "MovieAddBindingModel{" +
        "genre=" + genre +
        ", name='" + name + '\'' +
        ", poster='" + poster + '\'' +
        ", trailer='" + trailer + '\'' +
        ", description='" + description + '\'' +
        ", rating=" + rating +
        ", releaseDate=" + releaseDate +
        ", director=" + director +
        '}';
  }
}
