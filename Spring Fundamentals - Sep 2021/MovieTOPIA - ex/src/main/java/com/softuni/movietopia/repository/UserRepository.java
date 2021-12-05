package com.softuni.movietopia.repository;

import com.softuni.movietopia.model.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>  {

  Optional<UserEntity> findByUsername(String userName);
}
