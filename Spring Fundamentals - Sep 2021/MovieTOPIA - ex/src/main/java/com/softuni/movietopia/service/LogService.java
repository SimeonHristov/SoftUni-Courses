package com.softuni.movietopia.service;

import com.softuni.movietopia.model.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(String action, Long movieId);

    List<LogServiceModel> findAllLogs();
}
