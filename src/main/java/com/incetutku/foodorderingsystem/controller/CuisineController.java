package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.service.CuisineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuisines")
public class CuisineController {

    private final CuisineService cuisineService;

    public CuisineController(CuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    @PostMapping
    public ResponseEntity<CuisineDTO> createCuisine(@RequestBody CuisineDTO cuisineDTO) {
        return new ResponseEntity<>(cuisineService.save(cuisineDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CuisineDTO>> getAllCuisines() {
        return ResponseEntity.ok(cuisineService.getAll());
    }
}
