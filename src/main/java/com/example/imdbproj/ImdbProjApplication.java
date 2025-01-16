package com.example.imdbproj;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class ImdbProjApplication {

	@Autowired
	ImdbRepo repository;


	public static void main(String[] args) {
		SpringApplication.run(ImdbProjApplication.class, args);
	}


	@GetMapping("/movies")
	public String getMovies(@RequestParam(id="id", defaultValue="World") String id ){
		Iterable<Movie> movies = repository.findAll();
		return movies.toString();
    }

	@Bean
	CommandLineRunner loadData(MovieService movieService) {
		return args -> movieService.processTSV();
	}

}
