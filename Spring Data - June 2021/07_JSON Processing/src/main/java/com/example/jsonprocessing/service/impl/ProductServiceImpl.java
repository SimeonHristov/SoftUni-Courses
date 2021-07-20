package com.example.jsonprocessing.service.impl;

import com.example.jsonprocessing.constants.GlobalConstants;
import com.example.jsonprocessing.model.dto.ProductSeedDto;
import com.example.jsonprocessing.model.entity.Product;
import com.example.jsonprocessing.repository.ProductRepository;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.service.ProductService;
import com.example.jsonprocessing.service.UserService;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.jsonprocessing.constants.GlobalConstants.RESOURCE_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_NAME ="products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productRepository.count() > 0 ) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);

                    product.setSeller(userService.findRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(500L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }

                    product.setCategories(categoryService.findRandomCategory());

                    return product;
                })
                .forEach(productRepository::save);
    }
}
