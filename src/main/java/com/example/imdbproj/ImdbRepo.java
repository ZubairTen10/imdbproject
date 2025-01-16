package com.example.imdbproj;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImdbRepo extends JpaRepository<Movie, String> {

}
