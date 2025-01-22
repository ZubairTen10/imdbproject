package com.example.imdbproj;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MovieRating{
    @Id
    @Column(name="tconst")
    public String tconstId;

    public double averageRating;

    public int numVotes;

    public MovieRating(){
    }

    @OneToOne(mappedBy = "movieRating", cascade= CascadeType.ALL)
    private Movie movie;

    public void setTconst(String tconstId) {
        this.tconstId = tconstId;
    }


    public void setAverageRating(String averageRating) {
        this.averageRating = Double.parseDouble(averageRating);
    }

    public void setNumVotes(String numVotes) {
        this.numVotes = Integer.parseInt(numVotes);
    }

    @Override
    public String toString() {
        return String.format(
                " ID = '%s' | average rating = '%,.2f' | numvotes = '%05d' |",
                tconstId,averageRating,numVotes);
    }


}
