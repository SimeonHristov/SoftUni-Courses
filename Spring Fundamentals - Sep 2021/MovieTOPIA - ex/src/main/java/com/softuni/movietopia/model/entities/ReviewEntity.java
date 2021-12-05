package com.softuni.movietopia.model.entities;

import com.softuni.movietopia.model.entities.enums.Genre;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class ReviewEntity extends BaseEntity {

  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Genre genre;
  @Column(nullable = false)
  private String content;
  @Column(nullable = false)
  private Instant createdOn;
  @ManyToOne
  private UserEntity userEntity;

  public String getTitle() {
    return title;
  }

  public ReviewEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public Genre getGenre() {
    return genre;
  }

  public ReviewEntity setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ReviewEntity setContent(String content) {
    this.content = content;
    return this;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public ReviewEntity setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }

  public Instant getCreatedOn() {
    return createdOn;
  }

  public ReviewEntity setCreatedOn(Instant createdOn) {
    this.createdOn = createdOn;
    return this;
  }
}
