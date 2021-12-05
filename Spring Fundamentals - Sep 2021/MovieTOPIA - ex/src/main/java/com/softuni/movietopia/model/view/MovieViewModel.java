package com.softuni.movietopia.model.view;

import com.softuni.movietopia.model.entities.enums.Genre;
import java.math.BigDecimal;
import java.time.Instant;

public class MovieViewModel {

  private Long id;
  private String name;
  private String poster;
  private String trailer;
  private String description;
  private BigDecimal rating;
  private Instant releaseDate;
  private Genre genre;
  private String director;

  public MovieViewModel() {
  }

  public Long getId() {
    return id;
  }

  public MovieViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public MovieViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getPoster() {
    return poster;
  }

  public MovieViewModel setPoster(String poster) {
    this.poster = poster;
    return this;
  }

  public String getTrailer() {
    return trailer;
  }

  public MovieViewModel setTrailer(String trailer) {
    this.trailer = trailer;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public MovieViewModel setDescription(String description) {
    this.description = description;
    return this;
  }


  public BigDecimal getRating() {
    return rating;
  }

  public MovieViewModel setRating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  public Instant getReleaseDate() {
    return releaseDate;
  }

  public MovieViewModel setReleaseDate(Instant releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public MovieViewModel setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getDirector() {
    return director;
  }

  public MovieViewModel setDirector(String director) {
    this.director = director;
    return this;
  }
}
