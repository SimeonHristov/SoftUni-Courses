package com.softuni.movietopia.web;

import com.softuni.movietopia.model.entities.MovieEntity;
import com.softuni.movietopia.model.entities.DirectorEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.entities.enums.Genre;
import com.softuni.movietopia.repository.MovieRepository;
import com.softuni.movietopia.repository.DirectorRepository;
import com.softuni.movietopia.repository.LogRepository;
import com.softuni.movietopia.repository.UserRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

class MovieTestData {

  private long testMovieId;

  private UserRepository userRepository;
  private DirectorRepository directorRepository;
  private MovieRepository movieRepository;
  private LogRepository logRepository;

  public MovieTestData(UserRepository userRepository,
                       DirectorRepository directorRepository,
                       MovieRepository movieRepository, LogRepository logRepository) {
    this.userRepository = userRepository;
    this.directorRepository = directorRepository;
    this.movieRepository = movieRepository;
    this.logRepository = logRepository;
  }

  public void init() {
    DirectorEntity directorEntity = new DirectorEntity();
    directorEntity.setName("QWEQWE");
    directorEntity.setBio("Some info");
    directorEntity = directorRepository.save(directorEntity);

    UserEntity userEntity = new UserEntity();
    userEntity.setUsername("pesho").setPassword("qweqwe").setFullname("pesho pesho");
    userEntity = userRepository.save(userEntity);

    MovieEntity randomMovie = new MovieEntity();
    randomMovie.
        setName("randomMovie name").
            setPoster("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/best-movies-1614634680.jpg").
            setTrailer("9ix7TUGVYIo").
        setDescription("Sample description").
            setRating(BigDecimal.TEN).
        setReleaseDate(LocalDate.of(1988, 3, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()).
        setGenre(Genre.FICTION).
        setDirector(directorEntity.getName()).
        setUserEntity(userEntity);

    randomMovie = movieRepository.save(randomMovie);

    MovieEntity anotherRandomMovie = new MovieEntity();
    anotherRandomMovie.
        setName("anotherRandomMovie").
            setPoster("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/best-movies-1614634680.jpg").
            setTrailer("9ix7TUGVYIo").
        setDescription("Sample description").
            setRating(BigDecimal.TEN).
        setReleaseDate(LocalDate.of(1988, 3, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()).
        setGenre(Genre.ACTION).
        setDirector(directorEntity.getName()).
        setUserEntity(userEntity);

    anotherRandomMovie = movieRepository.save(anotherRandomMovie);


    testMovieId = anotherRandomMovie.getId();
  }

  void cleanUp() {
    logRepository.deleteAll();
    movieRepository.deleteAll();
    directorRepository.deleteAll();
    userRepository.deleteAll();
  }

  public long getTestMovieId() {
    return testMovieId;
  }
}
