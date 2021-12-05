package com.softuni.movietopia.repository;

import com.softuni.movietopia.model.entities.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long>  {

    @Query("SELECT a.name FROM DirectorEntity a")
    List<String> findAllDirectorNames();

    Optional<DirectorEntity> findByName(String name);
}
