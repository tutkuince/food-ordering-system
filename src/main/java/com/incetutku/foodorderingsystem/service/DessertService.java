package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DessertDTO;

import java.util.List;

public interface DessertService {
    DessertDTO save(DessertDTO dessertDTO);

    DessertDTO getDessertById(Long id);

    List<DessertDTO> getDessertsByCuisineId(Long cuisineId);

    List<DessertDTO> getAllDesserts();
}
