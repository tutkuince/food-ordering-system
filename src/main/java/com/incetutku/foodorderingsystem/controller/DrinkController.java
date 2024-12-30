package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping
    public ResponseEntity<DrinkDTO> createDrink(@RequestBody DrinkDTO drinkDTO) {
        return new ResponseEntity<>(drinkService.save(drinkDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DrinkDTO>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrinkDTO> getDrinkById(@PathVariable Long id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }
}
