package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.exceptions.ObjectNotFoundException;
import com.softuni.movietopia.model.entities.ReviewEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.service.ReviewServiceModel;
import com.softuni.movietopia.model.view.MovieViewModel;
import com.softuni.movietopia.model.view.ReviewViewModel;
import com.softuni.movietopia.repository.ReviewRepository;
import com.softuni.movietopia.repository.UserRepository;
import com.softuni.movietopia.service.ReviewService;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  private final ModelMapper modelMapper;
  private final ReviewRepository reviewRepository;
  private final UserRepository userRepository;

  public ReviewServiceImpl(ModelMapper modelMapper,
                           ReviewRepository reviewRepository,
                           UserRepository userRepository) {
    this.modelMapper = modelMapper;
    this.reviewRepository = reviewRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Optional<ReviewViewModel> findLatestReview() {
    return reviewRepository.
        findTopByOrderByCreatedOnDesc().
        map(ae -> {
          ReviewViewModel avm = modelMapper.map(ae, ReviewViewModel.class);
          avm.setAuthor(ae.getUserEntity().getUsername());
          return avm;
        });
  }

  @Override
  public List<ReviewViewModel> findAllReviews() {
    return reviewRepository.
        findAll().
        stream().
        map(reviewEntity -> {
          ReviewViewModel rvm = modelMapper.map(reviewEntity, ReviewViewModel.class);
          rvm.setAuthor(reviewEntity.getUserEntity().getUsername());
          return rvm;
        }).
        collect(Collectors.toList());
  }

  @Override
  public void createReview(ReviewServiceModel reviewServiceModel) {

    ReviewEntity reviewEntity = modelMapper.map(reviewServiceModel, ReviewEntity.class);
    reviewEntity.setCreatedOn(Instant.now());

    UserEntity creator = userRepository.
        findByUsername(reviewServiceModel.getUser()).
        orElseThrow(() -> new IllegalArgumentException("Creator " + reviewServiceModel.getUser() + " could not be found"));

    reviewEntity.setUserEntity(creator);

    reviewRepository.save(reviewEntity);
  }

    @Override
    public List<ReviewViewModel> getAllReviews() {
        return reviewRepository.
                findAll().
                stream().
                map(reviewEntity -> modelMapper.map(reviewEntity, ReviewViewModel.class)).
                collect(Collectors.toList());
    }

    @Override
    public ReviewViewModel findReviewByID(Long id) {
        return reviewRepository
                .findById(id)
                .map(reviewEntity -> {
                    ReviewViewModel reviewViewModel = modelMapper
                            .map(reviewEntity, ReviewViewModel.class);
                    reviewViewModel.setCreatedOd(reviewEntity.getCreatedOn().atZone(ZoneOffset.UTC).toLocalDateTime());
                    return reviewViewModel;
                })
                .orElseThrow(ObjectNotFoundException::new);
    }
    }
