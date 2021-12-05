package com.softuni.movietopia.web;

import com.softuni.movietopia.model.view.MovieViewModel;
import com.softuni.movietopia.repository.MovieRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieRestController {

  private final MovieRepository movieRepository;
  private final ModelMapper modelMapper;

  public MovieRestController(MovieRepository movieRepository,
                             ModelMapper modelMapper) {
    this.movieRepository = movieRepository;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/api")
  public ResponseEntity<List<MovieViewModel>> findAll() {

    List<MovieViewModel> movieViewModels = movieRepository.
        findAll().
        stream().
        map(ae -> {
          MovieViewModel viewModel = modelMapper.map(ae, MovieViewModel.class);
          viewModel.setDirector(ae.getDirector());
          return viewModel;
        }).
        collect(Collectors.toList());

    return ResponseEntity
            .ok()
            .body(movieViewModels);
  }
}
