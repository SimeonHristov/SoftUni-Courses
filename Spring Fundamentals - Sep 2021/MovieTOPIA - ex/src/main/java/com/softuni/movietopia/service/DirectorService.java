package com.softuni.movietopia.service;

import com.softuni.movietopia.model.entities.DirectorEntity;

import java.util.List;

public interface DirectorService {

  List<String> findAllDirectors();

  void seedDirectors();

  DirectorEntity findByName(String director);
}
