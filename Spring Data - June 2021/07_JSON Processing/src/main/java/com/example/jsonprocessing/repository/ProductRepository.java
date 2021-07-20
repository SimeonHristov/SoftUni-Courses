package com.example.jsonprocessing.repository;

import com.example.jsonprocessing.model.entity.Category;
import com.example.jsonprocessing.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
