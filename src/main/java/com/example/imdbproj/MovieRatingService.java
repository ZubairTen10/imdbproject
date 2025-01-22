package com.example.imdbproj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class MovieRatingService {

    String RATINGS_FILE = "C:\\Users\\Zubair.Syed\\Desktop\\title.ratings.tsv\\";
    BufferedReader reader;

    String line = " ";
    int lineCount = 0;
    @Autowired
    ImdbRatingRepo imdbRatingRepo;
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);


    public void processRatingsTSV() {
        logger.info("Starting loading ratings data");

        try {
            reader = new BufferedReader(new FileReader(RATINGS_FILE));
            reader.readLine(); // Discard headings
                while ((line = reader.readLine()) != null){
                    if(lineCount >= 200){
                            break;
                        }
                        String[] lineSplitTsvArray = line.split("\t");
                        MovieRating movieRating = new MovieRating();
                        movieRating.setTconst(lineSplitTsvArray[0]);
                        movieRating.setAverageRating(lineSplitTsvArray[1]);
                        movieRating.setNumVotes(lineSplitTsvArray[2]);
                        imdbRatingRepo.save(movieRating);
                        lineCount++;
                    }
                }catch(Exception e){
            System.err.println("Error processing line: " + line);
            e.printStackTrace();
        }

        logger.info("Successfully loaded 200 lines of movie ratings data");
    }
}

