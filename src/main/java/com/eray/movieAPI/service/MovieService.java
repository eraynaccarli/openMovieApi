package com.eray.movieAPI.service;

import com.eray.movieAPI.constans.Constants;
import com.eray.movieAPI.dto.MovieDto;
import com.eray.movieAPI.dto.MovieResponse;
import com.eray.movieAPI.dto.Results;
import com.eray.movieAPI.model.MovieEntity;
import com.eray.movieAPI.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate;
    private final MovieRepository movieRepository;


    private String API_URL = "https://api.themoviedb.org/3/search/movie?api_key=";

    public MovieService(RestTemplate restTemplate, MovieRepository movieRepository) {
        this.restTemplate = restTemplate;
        this.movieRepository = movieRepository;
    }

    public MovieDto getMovieByTitle(String title){
        logger.info("Requested movie : " + title);
        Optional<MovieEntity> movieEntityOptional = movieRepository.findByTitle(title);
        if(!movieEntityOptional.isPresent()){
            return MovieDto.convert(getMovieFromTheMovieApi(title));
        }
            return MovieDto.convert(movieEntityOptional.get());
    }

    private MovieEntity getMovieFromTheMovieApi(String title){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.API_URL + Constants.API_KEY + Constants.QUERY_KEY_PARAM + title, String.class);

        try {
            MovieResponse movieResponse = objectMapper.readValue(responseEntity.getBody(), MovieResponse.class);
            return saveMovieEntity(title , movieResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    private MovieEntity saveMovieEntity(String title, MovieResponse movieResponse){

        MovieEntity movieEntity = new MovieEntity(
                movieResponse.results().get(0).original_language(),
                movieResponse.results().get(0).original_title(),
                movieResponse.results().get(0).release_date(),
                movieResponse.results().get(0).overview(),
                movieResponse.results().get(0).popularity(),
                movieResponse.page().getPage()
        );
        return movieRepository.save(movieEntity);
    }


}
