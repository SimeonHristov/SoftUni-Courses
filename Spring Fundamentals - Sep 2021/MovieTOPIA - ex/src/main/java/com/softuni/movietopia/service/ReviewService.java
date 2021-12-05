package com.softuni.movietopia.service;

import com.softuni.movietopia.model.service.ReviewServiceModel;
import com.softuni.movietopia.model.view.MovieViewModel;
import com.softuni.movietopia.model.view.ReviewViewModel;
import java.util.List;
import java.util.Optional;

public interface ReviewService {

  Optional<ReviewViewModel> findLatestReview();

  List<ReviewViewModel> findAllReviews();

  void createReview(ReviewServiceModel reviewServiceModel);

  List<ReviewViewModel>  getAllReviews();

  ReviewViewModel findReviewByID(Long id);
}
