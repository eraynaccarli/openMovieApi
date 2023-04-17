package com.eray.movieAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieResponse (
        Page page,
        List<Results> results) {

}
