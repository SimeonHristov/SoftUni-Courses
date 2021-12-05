package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.exceptions.ObjectNotFoundException;
import com.softuni.movietopia.model.entities.MovieEntity;
import com.softuni.movietopia.model.entities.DirectorEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.entities.UserRoleEntity;
import com.softuni.movietopia.model.service.MovieServiceModel;
import com.softuni.movietopia.model.view.MovieViewModel;
import com.softuni.movietopia.repository.MovieRepository;
import com.softuni.movietopia.repository.UserRepository;
import com.softuni.movietopia.service.MovieService;
import com.softuni.movietopia.service.DirectorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.softuni.movietopia.model.entities.enums.UserRole.ADMIN;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final DirectorService directorService;
    private final ModelMapper modelMapper;

    public MovieServiceImpl(MovieRepository movieRepository,
                            UserRepository userRepository,
                            DirectorService directorService, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.directorService = directorService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addMovie(MovieServiceModel serviceModel) {
        MovieEntity movieEntity = modelMapper.map(serviceModel, MovieEntity.class);
        UserEntity creator = userRepository.
                findByUsername(serviceModel.getUser()).
                orElseThrow(() -> new IllegalArgumentException("Creator " + serviceModel.getUser() + " could not be found"));
        movieEntity.setUserEntity(creator);

        DirectorEntity directorEntity = directorService
                .findByName(serviceModel.getDirector());

        movieEntity.setDirector(directorEntity.getName());

        movieRepository.save(movieEntity);
    }

    @Override
    public MovieViewModel findById(Long id) {
        return movieRepository
                .findById(id)
                .map(movieEntity -> {
                    MovieViewModel movieViewModel = modelMapper
                            .map(movieEntity, MovieViewModel.class);
                    movieViewModel.setDirector(movieEntity.getDirector());
                    return movieViewModel;
                })
                .orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public MovieEntity findEntityById(Long movieId) {
        return movieRepository
                .findById(movieId)
                .orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieViewModel> getAllMovies() {
        return movieRepository.
                findAll().
                stream().
                map(movieEntity -> modelMapper.map(movieEntity, MovieViewModel.class)).
                collect(Collectors.toList());
    }
}

