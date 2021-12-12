package com.softuni.movietopia.service;

import com.softuni.movietopia.model.view.RequestView;

public interface RequestService {
    void onRequest();
    RequestView getRequests();
}
