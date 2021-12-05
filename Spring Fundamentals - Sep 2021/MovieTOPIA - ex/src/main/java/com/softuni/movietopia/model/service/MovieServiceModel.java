package com.softuni.movietopia.model.service;

import com.softuni.movietopia.model.entities.enums.Genre;

import java.math.BigDecimal;
import java.time.Instant;

public class MovieServiceModel {

  private String name;
  private String poster;
  private String trailer;
  private String description;
  private BigDecimal rating;
  private Instant releaseDate;
  private Genre genre;
  private String director;
  private String user;

  public MovieServiceModel() {
  }

  public String getName() {
    return name;
  }

  public MovieServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getPoster() {
    return poster;
  }

  public MovieServiceModel setPoster(String poster) {
    this.poster = poster;
    return this;
  }

  public String getTrailer() {
    return trailer;
  }

  public MovieServiceModel setTrailer(String trailer) {
    this.trailer = trailer;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public MovieServiceModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public MovieServiceModel setRating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  public Instant getReleaseDate() {
    return releaseDate;
  }

  public MovieServiceModel setReleaseDate(Instant releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public MovieServiceModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getDirector() {
    return director;
  }

  public MovieServiceModel setDirector(String director) {
    this.director = director;
    return this;
  }

  public String getUser() {
    return user;
  }

  public MovieServiceModel setUser(String user) {
    this.user = user;
    return this;
  }
}
