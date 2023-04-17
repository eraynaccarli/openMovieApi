package com.eray.movieAPI.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
public class MovieEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String language;

    private String title;

    private String releaseDate;

    @Column(length = 1024)
    private String overview;

    private Number popularity;

    private Integer page;

    public MovieEntity() {
    }

    public MovieEntity(String language, String title, String releaseDate, String overview, Number popularity,Integer page) {
        this.language = language;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.popularity = popularity;
        this.page = page;
    }

    public MovieEntity(String id, String language, String title, String releaseDate, String overview, Number popularity,Integer page) {
        this.id = id;
        this.language = language;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.popularity = popularity;
        this.page = page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Number getPopularity() {
        return popularity;
    }

    public void setPopularity(Number popularity) {
        this.popularity = popularity;
    }
}
