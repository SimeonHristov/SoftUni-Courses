package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.model.entities.MovieEntity;
import com.softuni.movietopia.model.entities.LogEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.service.LogServiceModel;
import com.softuni.movietopia.repository.LogRepository;
import com.softuni.movietopia.service.MovieService;
import com.softuni.movietopia.service.LogService;
import com.softuni.movietopia.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final MovieService movieService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public LogServiceImpl(LogRepository logRepository, MovieService movieService, UserService userService, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.movieService = movieService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createLog(String action, Long movieId) {
        MovieEntity movieEntity = movieService
                .findEntityById(movieId);

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();
        UserEntity userEntity = userService.findByName(username);

        LogEntity logEntity = new LogEntity()
                .setMovieEntity(movieEntity)
                .setUserEntity(userEntity)
                .setAction(action)
                .setDateTime(LocalDateTime.now());

        logRepository.save(logEntity);

    }

    @Override
    public List<LogServiceModel> findAllLogs() {
        return logRepository
                .findAll()
                .stream()
                .map(logEntity -> {
                    LogServiceModel logServiceModel = modelMapper
                            .map(logEntity, LogServiceModel.class);
                    logServiceModel.setMovie(logEntity.getMovieEntity().getName())
                            .setUser(logEntity.getUserEntity().getUsername());

                    return logServiceModel;
                })
                .collect(Collectors.toList());
    }
}
