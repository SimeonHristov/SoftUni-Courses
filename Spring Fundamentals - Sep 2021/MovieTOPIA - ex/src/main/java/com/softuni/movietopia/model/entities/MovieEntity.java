package com.softuni.movietopia.model.entities;

import com.softuni.movietopia.model.entities.enums.Genre;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class MovieEntity extends BaseEntity {

  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String poster;
  private String trailer;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private BigDecimal rating;
  @Column(nullable = false)
  private Instant releaseDate;
  @Enumerated(EnumType.STRING)
  private Genre genre;
  @Column(nullable = false)
  private String director;
  @ManyToOne
  private UserEntity userEntity;

  public String getName() {
    return name;
  }

  public MovieEntity setName(String name) {
    this.name = name;
    return this;
  }

  public String getPoster() {
    return poster;
  }

  public MovieEntity setPoster(String poster) {
    this.poster = poster;
    return this;
  }

  public String getTrailer() {
    return trailer;
  }

  public MovieEntity setTrailer(String trailer) {
    this.trailer = trailer;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public MovieEntity setDescription(String description) {
    this.description = description;
    return this;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public MovieEntity setRating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  public Instant getReleaseDate() {
    return releaseDate;
  }

  public MovieEntity setReleaseDate(Instant releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public MovieEntity setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getDirector() {
    return director;
  }

  public MovieEntity setDirector(String director) {
    this.director = director;
    return this;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public MovieEntity setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }
}
