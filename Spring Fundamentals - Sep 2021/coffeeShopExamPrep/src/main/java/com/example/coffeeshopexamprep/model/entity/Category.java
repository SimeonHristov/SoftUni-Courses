package com.example.coffeeshopexamprep.model.entity;

import com.example.coffeeshopexamprep.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "categories")
public class Category extends BaseEntity{


    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }

    @Enumerated(value = EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
