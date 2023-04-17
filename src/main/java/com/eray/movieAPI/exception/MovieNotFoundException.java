package com.eray.movieAPI.exception;

public class MovieNotFoundException extends  RuntimeException{
    public MovieNotFoundException(String message) {
        super(message);
    }
}
