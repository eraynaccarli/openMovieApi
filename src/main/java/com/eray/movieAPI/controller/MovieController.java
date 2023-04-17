package com.eray.movieAPI.controller;

import com.eray.movieAPI.dto.MovieDto;
import com.eray.movieAPI.service.MovieService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/movie")
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<MovieDto> getMovieByMovieTitle(@PathVariable @NotBlank String title){
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }
}
