package com.example.structure.service;

import com.example.structure.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long gameId);

    void allGames();

    void detailsGame(String gameTitle);
}