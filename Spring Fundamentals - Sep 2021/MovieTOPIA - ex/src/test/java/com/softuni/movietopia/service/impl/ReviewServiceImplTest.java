package com.softuni.movietopia.service.impl;

import static org.mockito.Mockito.when;

import com.softuni.movietopia.model.entities.ReviewEntity;
import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.entities.enums.Genre;
import com.softuni.movietopia.model.view.ReviewViewModel;
import com.softuni.movietopia.repository.ReviewRepository;
import com.softuni.movietopia.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

  private UserEntity testUser1, testUser2;
  private ReviewEntity testReviewEntity1, testReviewEntity2;


  private ReviewServiceImpl serviceToTest;

  @Mock
  ReviewRepository mockReviewRepository;

  @Mock
  UserRepository mockUserRepository;

  @BeforeEach
  public void init() {

    testUser1 = new UserEntity();
    testUser1.setUsername("user 1");

    testReviewEntity1 = new ReviewEntity();
    testReviewEntity1.setTitle("review 1");
    testReviewEntity1.setGenre(Genre.FICTION);
    testReviewEntity1.setContent("content 1");
    testReviewEntity1.setUserEntity(testUser1);

    testUser2 = new UserEntity();
    testUser2.setUsername("user 2");

    testReviewEntity2 = new ReviewEntity();
    testReviewEntity2.setTitle("review 2");
    testReviewEntity2.setGenre(Genre.ACTION);
    testReviewEntity2.setContent("content 2");
    testReviewEntity2.setUserEntity(testUser2);

    serviceToTest = new ReviewServiceImpl(new ModelMapper(), mockReviewRepository, mockUserRepository);
  }

  @Test
  public void testFindAll() {

    when(mockReviewRepository.findAll()).thenReturn(List.of(testReviewEntity1, testReviewEntity2));

    List<ReviewViewModel> allModels = serviceToTest.findAllReviews();

    Assertions.assertEquals(2, allModels.size());

    ReviewViewModel model1 = allModels.get(0);
    ReviewViewModel model2 = allModels.get(1);

    Assertions.assertEquals(testReviewEntity1.getTitle(), model1.getTitle());
    Assertions.assertEquals(testReviewEntity1.getGenre(), model1.getGenre());
    Assertions.assertEquals(testReviewEntity1.getContent(), model1.getContent());
    Assertions.assertEquals(testUser1.getUsername(), model1.getAuthor());

    Assertions.assertEquals(testReviewEntity2.getTitle(), model2.getTitle());
    Assertions.assertEquals(testReviewEntity2.getGenre(), model2.getGenre());
    Assertions.assertEquals(testReviewEntity2.getContent(), model2.getContent());
    Assertions.assertEquals(testUser2.getUsername(), model2.getAuthor());
  }

  @Test
  void testLatestReview() {
    when(mockReviewRepository.findTopByOrderByCreatedOnDesc()).thenReturn(Optional.of(testReviewEntity1));

    Optional<ReviewViewModel> reviewViewOpt = serviceToTest.findLatestReview();

    Assertions.assertTrue(reviewViewOpt.isPresent());
    ReviewViewModel actualModel = reviewViewOpt.get();

    Assertions.assertEquals(testReviewEntity1.getTitle(), actualModel.getTitle());
    Assertions.assertEquals(testReviewEntity1.getContent(), actualModel.getContent());
  }

  @Test
  void testLatestReview_NotFound() {
    when(mockReviewRepository.findTopByOrderByCreatedOnDesc()).thenReturn(Optional.empty());

    Optional<ReviewViewModel> reviewViewOpt = serviceToTest.findLatestReview();

    Assertions.assertTrue(reviewViewOpt.isEmpty());
  }

}
