package com.example.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    
    @GetMapping("/ping")
    public ResponseEntity<?> getCatalog() {
        return new ResponseEntity<>("Catalog Response", HttpStatus.OK);
    }

}
