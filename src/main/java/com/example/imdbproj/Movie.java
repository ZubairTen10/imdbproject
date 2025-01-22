package com.example.imdbproj;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie {

    @Id
    @Column(name="tconst")
    private String tconst;


    private String titleType;
    @Column(length = 500)
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private LocalDate startYear;
    private LocalDate endYear;
    private long runtimeMinutes;
    private String genres; // Store as a comma-separated string

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private MovieRating movieRating;

    public Movie() {
    }

    private static final Logger logger = LoggerFactory.getLogger(Movie.class);

    @Override
    public String toString() {
        return String.format(
                " ID = '%s' | Movie Type = '%s' | Title = '%s' | Genre = '%s' | ",
                tconst, titleType, primaryTitle, genres);
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }


}

