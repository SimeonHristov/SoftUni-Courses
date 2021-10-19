package com.example.coffeeshopexamprep.service.Impl;

import com.example.coffeeshopexamprep.model.entity.Category;
import com.example.coffeeshopexamprep.model.entity.enums.CategoryNameEnum;
import com.example.coffeeshopexamprep.repository.CategoryRepository;
import com.example.coffeeshopexamprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum){
                        case CAKE -> category.setNeededTime(10);
                        case COFFEE -> category.setNeededTime(1);
                        case DRINK -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);

                });

    }
}
