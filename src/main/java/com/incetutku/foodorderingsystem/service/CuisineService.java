package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;

import java.util.List;

public interface CuisineService {
    List<CuisineDTO> getAll();

    CuisineDTO save(CuisineDTO cuisineDTO);

    CuisineDTO getById(Long id);

}
