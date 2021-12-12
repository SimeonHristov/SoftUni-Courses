package com.softuni.movietopia.web;

import com.softuni.movietopia.service.CarouselService;
import com.softuni.movietopia.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

  private final CarouselService carouselService;
  private final MovieService movieService;
  private final ModelMapper modelMapper;

  public HomeController(CarouselService carouselService, MovieService movieService, ModelMapper modelMapper) {
    this.carouselService = carouselService;
    this.movieService = movieService;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/home")
  public String home(Model model) {

    model.addAttribute("firstImg", carouselService.firstImage());
    model.addAttribute("secondImg", carouselService.secondImage());
    model.addAttribute("thirdImg", carouselService.thirdImage());

    model.addAttribute("movies", movieService.getAllMovies());

    return "home";
  }

  @GetMapping("/home/{id}/details")
  public String showDetails(
          @PathVariable Long id,
          Model model) {
    model.addAttribute("movie", this.movieService.findById(id));
    return "details";
  }

  @DeleteMapping("/home/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String deleteMovie(@PathVariable Long id) {

    movieService.deleteMovie(id);

    return "redirect:/home";
  }

}
