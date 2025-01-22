package com.example.imdbproj;

public class MovieWithRating {


    public String primaryTitle;
    public Double averageRating;

    public MovieWithRating(String primaryTitle, Double averageRating){
        this.primaryTitle = primaryTitle;
        this.averageRating = averageRating;
    }


    public String getPrimaryTitle(){
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle){
        this.primaryTitle = primaryTitle;
    }


    public void setAverageRatingRating(){
        this.averageRating = averageRating;
    }


    @Override
    public String toString() {
        return String.format(" Title = '%s' | AverageRating = '%.2f'  ",
                primaryTitle, averageRating );
    }
}
