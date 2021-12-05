package com.softuni.movietopia.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.softuni.movietopia.model.entities.enums.Genre;
import com.softuni.movietopia.repository.MovieRepository;
import com.softuni.movietopia.repository.DirectorRepository;
import com.softuni.movietopia.repository.LogRepository;
import com.softuni.movietopia.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
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
public class MovieRestControllerTest {

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
  public void setUp() {
    testData = new MovieTestData(
        userRepository,
            directorRepository,
            movieRepository,
        logRepository
    );
    testData.init();
  }

  @AfterEach
  public void tearDown() {
    testData.cleanUp();
  }

  @Test
  @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
  void testFetchMovies() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/movies/api")).
        andExpect(status().isOk()).
        andExpect(jsonPath("[0].name").value("randomMovie")).
        andExpect(jsonPath("[0].genre").value(Genre.FICTION.name())).
        andExpect(jsonPath("[1].name").value("anotherRandomMovie")).
        andExpect(jsonPath("[1].genre").value(Genre.ACTION.name()));
  }
}
