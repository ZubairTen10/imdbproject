package com.example.imdbproj;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImdbRepo extends CrudRepository<Movie, String> {


}
