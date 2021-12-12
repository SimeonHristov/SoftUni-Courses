package com.softuni.movietopia.web;

import com.softuni.movietopia.model.binding.ReviewAddBindingModel;
import com.softuni.movietopia.model.service.ReviewServiceModel;
import com.softuni.movietopia.model.view.ReviewViewModel;
import com.softuni.movietopia.service.ReviewService;

import java.util.Optional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ModelMapper modelMapper;
    private final ReviewService reviewService;

    public ReviewController(ModelMapper modelMapper,
                            ReviewService reviewService) {
        this.modelMapper = modelMapper;
        this.reviewService = reviewService;
    }

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        Optional<ReviewViewModel> reviewOpt = reviewService.findLatestReview();
        if (reviewOpt.isPresent()) {
            model.addAttribute("latestReview", reviewOpt.get());
            model.addAttribute("reviews", reviewService.getAllReviews());
        }
        return "all-reviews";
    }

    @GetMapping("/add")
    public String addReview() {
        return "add-review";
    }

    @ModelAttribute("reviewAddBindingModel")
    public ReviewAddBindingModel createBindingModel() {
        return new ReviewAddBindingModel();
    }


    @PostMapping("/add")
    public String addReview(
            @Valid ReviewAddBindingModel reviewAddBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal UserDetails principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reviewAddBindingModel", reviewAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.reviewAddBindingModel", bindingResult);

            return "redirect:/reviews/add";
        }


        ReviewServiceModel reviewServiceModel = modelMapper.map(
                reviewAddBindingModel,
                ReviewServiceModel.class);

        reviewServiceModel.setUser(principal.getUsername());

        reviewService.createReview(reviewServiceModel);

        return "redirect:/reviews/all";
    }

    @GetMapping("reviews/{id}/details-review")
    public String reviewDetails(@PathVariable Long id,
                                Model model) {
        ReviewViewModel review = reviewService.findReviewByID(id);

        model.addAttribute("review", this.reviewService.findReviewByID(id));

        return "details-review";
    }

}
