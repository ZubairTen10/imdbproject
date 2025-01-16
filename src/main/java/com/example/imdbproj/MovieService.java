package com.example.imdbproj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


@Service
public class MovieService {
    BufferedReader reader = null;
    String line  = "";

    @Autowired
     ImdbRepo imdbRepo;


    public void processTSV() throws IOException    {
        try{
            String FILE_PATH = "C:\\Users\\Zubair.Syed\\Desktop\\name.basics.tsv\\";
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\t");
                Movie movie = new Movie();
                movie.setTconst(values[0]);
                imdbRepo.save(movie);
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
    }
}
