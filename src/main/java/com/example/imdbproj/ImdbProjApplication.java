package com.example.imdbproj;

import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(ImdbProjApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ImdbProjApplication.class, args);
	}


	@GetMapping("/movies")
	public String movieForm(Model model){
		model.addAttribute("movie", new Movie());
		return "movies";
	}


	@GetMapping("/results")
	public String getMovies(@RequestParam(value = "title") String title, Model model )
	{
		logger.info("Searching for movies with title: {}", title);
		List<Movie> movies = repository.findByPrimaryTitleOrOriginalTitle(title);
		model.addAttribute("movie", movies);
		logger.info("Movie found: {} ", movies);
		return "result";
    }

	@Bean
	CommandLineRunner loadData(MovieService movieService) {
		return args -> movieService.processTSV();
	}

}
