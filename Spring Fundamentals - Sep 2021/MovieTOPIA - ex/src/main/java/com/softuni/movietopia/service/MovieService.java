package com.softuni.movietopia.service;

import com.softuni.movietopia.model.entities.MovieEntity;
import com.softuni.movietopia.model.service.MovieServiceModel;
import com.softuni.movietopia.model.view.MovieViewModel;

import java.util.List;

public interface MovieService {
    void addMovie(MovieServiceModel serviceModel);

    MovieViewModel findById(Long id);

    MovieEntity findEntityById(Long movieId);

    void deleteMovie(Long id);

    List<MovieViewModel> getAllMovies();

}
