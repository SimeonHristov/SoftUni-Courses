package com.example.coffeeshopexamprep.web;


import com.example.coffeeshopexamprep.model.viewModels.OrderViewModel;
import com.example.coffeeshopexamprep.service.OrderService;
import com.example.coffeeshopexamprep.service.UserService;
import com.example.coffeeshopexamprep.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllByOrderByPriceDesc();

        model.addAttribute("orders",orders);
        model.addAttribute("totalTime",orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce((a,b) -> a + b)
                .orElse(0));

        model.addAttribute("users", userService.findAllUserAndCountOfOrdersOrderByCountDesc());

        return "home";
    }
}
