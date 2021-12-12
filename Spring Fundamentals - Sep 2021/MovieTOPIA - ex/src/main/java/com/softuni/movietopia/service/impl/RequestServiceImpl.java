package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.model.view.RequestView;
import com.softuni.movietopia.service.RequestService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    private int anonymRequest, authRequest;

    @Override
    public void onRequest() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequest++;
        }else{
            anonymRequest++;
        }

    }

    @Override
    public RequestView getRequests() {

        return new RequestView (anonymRequest,authRequest);
    }
}
