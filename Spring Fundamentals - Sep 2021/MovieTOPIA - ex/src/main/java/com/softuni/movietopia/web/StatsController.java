package com.softuni.movietopia.web;

import com.softuni.movietopia.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatsController {

    private final LogService logService;

    public StatsController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public String logData(Model model){
        model.addAttribute("logs",
                logService.findAllLogs());
        return "stats";
    }


}
