package com.softuni.movietopia.web;


import com.softuni.movietopia.model.binding.DirectorAddBindingModel;
import com.softuni.movietopia.model.binding.MovieAddBindingModel;
import com.softuni.movietopia.model.service.DirectorServiceModel;
import com.softuni.movietopia.model.service.MovieServiceModel;
import com.softuni.movietopia.service.DirectorService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.ZoneId;

@Controller
@RequestMapping("/directors")
public class DirectorController {


    private final ModelMapper modelMapper;
    private final DirectorService directorService;


    public DirectorController(ModelMapper modelMapper, DirectorService directorService) {
        this.modelMapper = modelMapper;
        this.directorService = directorService;
    }


    @ModelAttribute("directorAddBindingModel")
    public DirectorAddBindingModel createBindingModel() {
        return new DirectorAddBindingModel();
    }

    @GetMapping("/add")
    public String addDirector(Model model) {

        return "add-director";
    }

    @PostMapping("/add")
    public String addDirector(@Valid DirectorAddBindingModel directorAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails principal) {


        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("directorAddBindingModel", directorAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.directorAddBindingModel", bindingResult);

            return "redirect:home";
        }


        DirectorServiceModel directorServiceModel = modelMapper.map(
                directorAddBindingModel,
                DirectorServiceModel.class);

        directorServiceModel.setUser(principal.getUsername());

        directorService.addDirector(directorServiceModel);

        return "redirect:/home";
    }


}
