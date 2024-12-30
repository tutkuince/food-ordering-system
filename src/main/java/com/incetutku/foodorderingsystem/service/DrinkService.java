package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;

import java.util.List;

public interface DrinkService {
    DrinkDTO save(DrinkDTO drinkDTO);

    DrinkDTO getDrinkById(Long id);

    List<DrinkDTO> getAllDrinks();
}
