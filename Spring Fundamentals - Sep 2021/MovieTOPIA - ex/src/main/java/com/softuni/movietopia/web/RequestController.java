package com.softuni.movietopia.web;

import com.softuni.movietopia.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/requests")
    public ModelAndView statistics(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("stats", requestService.getRequests());
        modelAndView.setViewName("requests");
        return modelAndView;
    }
}
