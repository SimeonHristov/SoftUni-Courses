package com.example.pathfinderdemo.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private Long Id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
