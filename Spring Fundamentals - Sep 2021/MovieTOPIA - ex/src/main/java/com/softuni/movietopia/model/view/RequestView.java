package com.softuni.movietopia.model.view;

public class RequestView {
    private final int anonymRequest;
    private final int authRequest;

    public RequestView(int anonymRequest, int authRequest) {
        this.anonymRequest = anonymRequest;
        this.authRequest = authRequest;
    }

    public int getTotalRequest() {
        return anonymRequest + authRequest;
    }

    public int getAnonymRequest() {
        return anonymRequest;
    }


    public int getAuthRequest() {
        return authRequest;
    }
}
