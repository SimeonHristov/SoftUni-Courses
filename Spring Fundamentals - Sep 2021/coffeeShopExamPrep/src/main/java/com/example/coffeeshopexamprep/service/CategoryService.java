package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.entity.Category;
import com.example.coffeeshopexamprep.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
