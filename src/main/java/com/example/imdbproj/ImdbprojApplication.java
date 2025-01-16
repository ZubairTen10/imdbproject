package com.example.imdbproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class ImdbprojApplication {
	private static ImdbRepo repository;

	public ImdbprojApplication(ImdbRepo repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ImdbprojApplication.class, args);
	}


	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return repository.findAll();

	}
}
