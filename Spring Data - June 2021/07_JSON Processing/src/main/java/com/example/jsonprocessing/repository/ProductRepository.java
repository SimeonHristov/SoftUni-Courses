package com.example.jsonprocessing.repository;

import com.example.jsonprocessing.model.entity.Category;
import com.example.jsonprocessing.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findAllByPriceBetweenOrderByPriceDesc (BigDecimal lower, BigDecimal upper);

    //findAllByPriceBetweenAAndBuyerIsNullOrderByPriceDesc

    List<Product> findAllByPriceBetweenOrderByPriceDesc(BigDecimal lower, BigDecimal upper);
}


