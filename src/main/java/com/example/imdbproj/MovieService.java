package com.example.imdbproj;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


@Service
public class MovieService {
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
    BufferedReader reader = null;
    String line  = "";
    int lineCount = 0;

    @Autowired
     ImdbRepo imdbRepo;




    public void processTSV() throws IOException    {
        logger.info("Starting loading data");
        try{
            String FILE_PATH = "C:\\Users\\Zubair.Syed\\Desktop\\title.basics.tsv\\";
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null) {

                if (lineCount >= 200){
                    break;
                }
                String[] values = line.split("\t");
                Movie movie = new Movie();
                movie.setTconst(values[0]);
                movie.setTitleType(values[1]);
                movie.setPrimaryTitle(values[2]);
                movie.setOriginalTitle(values[3]);
                movie.setGenres(values[8]);
                imdbRepo.save(movie);
                lineCount++;
            }
        }
        catch(Exception e){
            System.err.println("Error processing line: " + line);
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        logger.info("Successfully loaded the first 200 lines of movie titles");
    }
}
