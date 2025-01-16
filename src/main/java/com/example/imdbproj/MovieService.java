package com.example.imdbproj;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

@Service
public class MovieService {
    BufferedReader reader = null;
    String line  = "";

    private void save() throws IOException    {
        try{
            String FILE_PATH = "C:\\Users\\Zubair.Syed\\Desktop\\name.basics.tsv\\";
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null); {
                String[] row = line.split("\t");
            }
        }
        catch(Exception e){

        }
    }
}
