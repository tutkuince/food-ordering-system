package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.service.DessertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/desserts")
public class DessertController {

    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping
    public ResponseEntity<DessertDTO> createDessert(@RequestBody DessertDTO dessertDTO) {
        return new ResponseEntity<>(dessertService.save(dessertDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DessertDTO>> getAllDesserts() {
        return ResponseEntity.ok(dessertService.getAllDesserts());
    }

    @GetMapping("/{cuisineId}")
    public ResponseEntity<List<DessertDTO>> getDessertsByCuisineId(@PathVariable Long cuisineId) {
        return ResponseEntity.ok(dessertService.getDessertsByCuisineId(cuisineId));
    }

}
