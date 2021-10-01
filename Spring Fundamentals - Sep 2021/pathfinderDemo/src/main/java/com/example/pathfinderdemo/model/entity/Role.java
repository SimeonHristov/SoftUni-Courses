package com.example.pathfinderdemo.model.entity;

import com.example.pathfinderdemo.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

    @Entity
    @Table(name = "roles")
    public class Role extends BaseEntity {

        private RoleNameEnum name;

        @Enumerated(EnumType.STRING)
        public RoleNameEnum getName() {
            return name;
        }

        public void setName(RoleNameEnum role) {
            this.name = role;
        }
    }
