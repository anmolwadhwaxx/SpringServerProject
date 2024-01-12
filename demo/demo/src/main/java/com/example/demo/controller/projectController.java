package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class projectController {

    @GetMapping("/health-check")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


    @GetMapping("/data")
    public ResponseEntity<String> getData(@RequestParam String n) throws IOException {

            String fileName = n + ".txt";
            ClassPathResource resource = new ClassPathResource(fileName); //will read the files from resource package

            if (resource.exists()) {
                String content = new String(resource.getInputStream().readAllBytes());
                return new ResponseEntity<>(content, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
            }

    }
}