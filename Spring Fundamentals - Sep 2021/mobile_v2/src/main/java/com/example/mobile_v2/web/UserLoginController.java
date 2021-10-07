package com.example.mobile_v2.web;

import com.example.mobile_v2.model.binding.UserLoginBindingModel;
import com.example.mobile_v2.model.service.UserLoginServiceModel;
import com.example.mobile_v2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/login")
    public String login () {
        return "auth-login";
    }

    @PostMapping("users/login")
    public String login (UserLoginBindingModel userLoginBindingModel) {


        //Delegate the logic to the service layer
       boolean loginSuccessful = userService
           .login(new UserLoginServiceModel()
               .setUserName(userLoginBindingModel.getUserName())
               .setRawPassword(userLoginBindingModel.getPassword()));

        return "redirect:/index";
    }
}
