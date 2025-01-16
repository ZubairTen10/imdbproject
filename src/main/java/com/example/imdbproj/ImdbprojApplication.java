package com.example.imdbproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class ImdbprojApplication {

	@Autowired
	ImdbRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(ImdbprojApplication.class, args);
	}


	@GetMapping("/movies")
	public String getMovies(
			@RequestParam(value = "id", defaultValue = "null")String id){
		Optional<Movie> optionalMovie = repository.findById(id);
		Movie movie1 = optionalMovie.orElse(null);
        return movie1.getTconst();
    }


}
