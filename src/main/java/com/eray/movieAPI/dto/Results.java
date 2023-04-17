package com.eray.movieAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public record Results(
         boolean adult,
         String backdrop_path,
         ArrayList<Object> genre_ids,
         Integer budget,
         ArrayList<Object> genres,
         Integer id,
         String original_language,
         String original_title,
         String overview,
         Number popularity,
         String poster_path,
         String release_date,
         String title,
         boolean video,
         Number  vote_average,
         Integer vote_count

){


}
