package com.example.imdbproj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class ImdbProjApplication {

	@Autowired
	ImdbRepo imdbRepo;
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
		List<Movie> movies = imdbRepo.findByPrimaryTitleOrOriginalTitle(title);
		model.addAttribute("movie", movies);
		logger.info("Movie found: {} ", movies);
		return "result";
    }

	@GetMapping("/moviesbyrating")
	public String movieRatingForm(Model model){
		model.addAttribute("movierating", new MovieRating());
		return "movieRatingForm";
	}

	@GetMapping("/ratingResults")
	public String getMoviesByRating(@RequestParam(value = "rating")Double rating, Model model){
		List<Movie> filteredMovies = imdbRepo.findByMovieRatingAverageRatingGreaterThan(rating);
		List<MovieWithRating> moviesWithRatings = new ArrayList<>();
		for (Movie movie: filteredMovies){
			moviesWithRatings.add(new MovieWithRating(movie.getPrimaryTitle(), movie.getMovieRating().getAverageRating()));
		}
		model.addAttribute("filteredMoviesWithRating", moviesWithRatings);
		return "ratingResults";
	}

	@Bean
	CommandLineRunner loadData(MovieService movieService) {
		return args -> movieService.processTSV();
	}

	@Bean
	CommandLineRunner loadRatingsData(MovieRatingService movieRatingService){    /*you need this specific annotation and commandlinerunner execution to actually execute the method movie rating serviec*/
		return args -> movieRatingService.processRatingsTSV();
	}

}
