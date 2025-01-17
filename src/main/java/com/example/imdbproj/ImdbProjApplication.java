package com.example.imdbproj;

import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Controller
public class ImdbProjApplication {

	@Autowired
	ImdbRepo repository;


	public static void main(String[] args) {
		SpringApplication.run(ImdbProjApplication.class, args);
	}


	@GetMapping("/movies")
	public String movieForm(Model model){
		model.addAttribute("movie", new Movie());
		return "movies";
	}


	@GetMapping("/results")
	public String getMovies(@RequestParam(value = "tconst") String tconst, @ModelAttribute Movie movie	, Model model ) {
		model.addAttribute("movie", movie);
		Optional<Movie> movies = repository.findById(tconst);
		model.addAttribute("movie", movies.get());
		return "result";
    }

	@Bean
	CommandLineRunner loadData(MovieService movieService) {
		return args -> movieService.processTSV();
	}

}
