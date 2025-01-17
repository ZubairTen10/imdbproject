package com.example.imdbproj;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface ImdbRepo extends CrudRepository<Movie, String>, QueryByExampleExecutor<Movie> {


}
