package com.softuni.movietopia.repository;

import com.softuni.movietopia.model.entities.ReviewEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

  Optional<ReviewEntity> findTopByOrderByCreatedOnDesc();
}
