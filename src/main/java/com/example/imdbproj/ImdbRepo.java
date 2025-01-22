package com.example.imdbproj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImdbRepo extends JpaRepository<Movie, String> {

   @Query("select m FROM Movie m WHERE LOWER(m.primaryTitle) = LOWER(:title) or LOWER(m.originalTitle) = LOWER(:title)")
   List<Movie> findByPrimaryTitleOrOriginalTitle(@Param("title") String title);


   List<Movie> findByMovieRatingAverageRatingGreaterThan(Double rating);



}
