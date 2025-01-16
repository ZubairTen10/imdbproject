package com.example.imdbproj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api"")
public class Controller {

    @PostMapping("uploadFilesIntoDB")
        public void storeFilesIntoDB(@RequestMapping MultipartFile file){

}
}
