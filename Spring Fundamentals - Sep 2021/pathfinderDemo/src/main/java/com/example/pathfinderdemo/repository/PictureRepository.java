package com.example.pathfinderdemo.repository;

import com.example.pathfinderdemo.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query("SELECT p.url FROM Picture p")
    List<String> findAllUrls();
}
