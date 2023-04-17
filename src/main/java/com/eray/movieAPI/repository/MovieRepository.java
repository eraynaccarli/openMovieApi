package com.eray.movieAPI.repository;

import com.eray.movieAPI.dto.MovieDto;
import com.eray.movieAPI.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, String > {
    Optional<MovieEntity> findByTitle(String title);
}
