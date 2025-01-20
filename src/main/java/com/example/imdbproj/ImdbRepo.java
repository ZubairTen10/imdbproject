package com.example.imdbproj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.util.Streamable;

import java.util.List;
import java.util.Optional;

public interface ImdbRepo extends JpaRepository<Movie, String> {

   @Query("select m FROM Movie m WHERE LOWER(m.primaryTitle) = LOWER(:title) or LOWER(m.originalTitle) = LOWER(:title)")
   List<Movie> findByPrimaryTitleOrOriginalTitle(@Param("title") String title);




}
