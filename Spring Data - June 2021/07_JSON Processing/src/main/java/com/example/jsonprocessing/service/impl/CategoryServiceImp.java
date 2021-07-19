package com.example.jsonprocessing.service.impl;

import com.example.jsonprocessing.model.dto.CategorySeedDto;
import com.example.jsonprocessing.model.entity.Category;
import com.example.jsonprocessing.repository.CategoryRepository;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.jsonprocessing.constants.GlobalConstants.RESOURCE_FILE_PATH;

@Service
public class CategoryServiceImp implements CategoryService {


    private static final String CATEGORIES_FILE_NAME = "categories.json";

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validaionUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, Gson gson, ValidationUtil validaionUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validaionUtil = validaionUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if ((categoryRepository.count() > 0)){
            return;
        }


        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validaionUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }
}

