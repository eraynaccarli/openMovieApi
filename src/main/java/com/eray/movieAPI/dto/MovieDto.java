package com.eray.movieAPI.dto;

import com.eray.movieAPI.model.MovieEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

public record MovieDto(

         String language,

         String title,

         String releaseDate,

         String overview,

         Number popularity,

         Integer page

) {
    public static MovieDto convert(MovieEntity from){
        return new MovieDto(from.getLanguage(),
                from.getTitle(),
                from.getReleaseDate(),
                from.getOverview(),
                from.getPopularity(),
                from.getPage());
    }
}
