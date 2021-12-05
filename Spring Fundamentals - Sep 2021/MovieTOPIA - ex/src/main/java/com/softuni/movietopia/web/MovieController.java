package com.softuni.movietopia.web;

import com.softuni.movietopia.aop.TrackLatency;
import com.softuni.movietopia.model.binding.MovieAddBindingModel;
import com.softuni.movietopia.model.service.MovieServiceModel;
import com.softuni.movietopia.service.MovieService;
import com.softuni.movietopia.service.DirectorService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.ZoneId;

@Controller
@RequestMapping("/movies")
public class MovieController {

  private final ModelMapper modelMapper;
  private final MovieService movieService;
  private final DirectorService directorService;

  public MovieController(ModelMapper modelMapper,
                         MovieService movieService,
                         DirectorService directorService) {
    this.modelMapper = modelMapper;
    this.movieService = movieService;
    this.directorService = directorService;
  }

  @ModelAttribute("movieAddBindingModel")
  public MovieAddBindingModel createBindingModel() {
    return new MovieAddBindingModel();
  }

  @GetMapping("/add")
  public String addMovie(Model model) {

    model.addAttribute("directors",
            directorService.findAllDirectors());

    return "add-movie";
  }

  @TrackLatency(latency = "adding movie")
  @PostMapping("/add")
  public String addMovie(@Valid MovieAddBindingModel movieAddBindingModel,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      @AuthenticationPrincipal UserDetails principal) {


    if(bindingResult.hasErrors()){
      redirectAttributes.addFlashAttribute("movieAddBindingModel", movieAddBindingModel);
      redirectAttributes
              .addFlashAttribute("org.springframework.validation.BindingResult.movieAddBindingModel", bindingResult);

      return "redirect:home";
    }


    MovieServiceModel movieServiceModel = modelMapper.map(
        movieAddBindingModel,
        MovieServiceModel.class);

    movieServiceModel.setUser(principal.getUsername());

   movieServiceModel.setReleaseDate(movieAddBindingModel
           .getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toInstant());


    movieService.addMovie(movieServiceModel);

    return "redirect:/home";
  }



}
