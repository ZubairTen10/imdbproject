package com.example.imdbproj;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImdbRatingRepo extends JpaRepository<MovieRating, String> {



}
