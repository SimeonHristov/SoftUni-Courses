package com.softuni.movietopia.DBinit;

import com.softuni.movietopia.service.DirectorService;
import com.softuni.movietopia.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieTopiaDBinit implements CommandLineRunner {

  private final UserService userService;
  private final DirectorService directorService;

  public MovieTopiaDBinit(UserService userService,
                          DirectorService directorService) {
    this.userService = userService;
    this.directorService = directorService;
  }

  @Override
  public void run(String... args) throws Exception {
    userService.seedUsers();
    directorService.seedDirectors();
  }
}
