package com.softuni.movietopia.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.softuni.movietopia.model.entities.enums.Genre;
import com.softuni.movietopia.repository.MovieRepository;
import com.softuni.movietopia.repository.DirectorRepository;
import com.softuni.movietopia.repository.LogRepository;
import com.softuni.movietopia.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MovieControllerTest {

  private static final String MOVIE_CONTROLLER_PREFIX = "/movies";

  private long testMovieId;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private DirectorRepository directorRepository;
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private LogRepository logRepository;

  private MovieTestData testData;

  @BeforeEach
  public void setup() {
    testData = new MovieTestData(
        userRepository,
            directorRepository,
            movieRepository,
            logRepository
    );
    testData.init();
    testMovieId = testData.getTestMovieId();
  }

  @AfterEach
  public void tearDown() {
    testData.cleanUp();
  }

  @Test
  @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
  void testShouldReturnValidStatusViewNameAndModel() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            MOVIE_CONTROLLER_PREFIX + "/details/{id}", testMovieId
    )).
        andExpect(status().isOk()).
        andExpect(view().name("details")).
        andExpect(model().attributeExists("movie"));
  }

  @Test
  @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
  void addMovie() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(MOVIE_CONTROLLER_PREFIX + "/add")
    .param("name", "test movie").
            param("genre", Genre.FICTION.name()).
            param("poster", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/best-movies-1614634680.jpg").
            param("trailer", "9ix7TUGVYIo").
            param("description", "Description test").
            param("releaseDate", "2000-01-01").
            param("director", "Quentin Tarantino").
          with(csrf())).
        andExpect(status().is3xxRedirection());

    Assertions.assertEquals(3, movieRepository.count());
  }
}
