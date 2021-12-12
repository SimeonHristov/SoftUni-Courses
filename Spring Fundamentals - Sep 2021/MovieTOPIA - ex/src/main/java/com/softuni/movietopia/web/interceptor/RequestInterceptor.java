package com.softuni.movietopia.web.interceptor;

import com.softuni.movietopia.service.RequestService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final RequestService requestService;

    public RequestInterceptor(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestService.onRequest();
        return true;
    }
}
