package com.softuni.movietopia.repository;

import com.softuni.movietopia.model.entities.UserRoleEntity;
import com.softuni.movietopia.model.entities.enums.UserRole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  Optional<UserRoleEntity> findByRole(UserRole role);
}
