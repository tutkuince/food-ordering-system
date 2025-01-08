package com.incetutku.foodorderingsystem.mapper;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.entity.Dessert;

public class DessertMapper {
    private DessertMapper() {
    }

    public static Dessert mapToDessert(DessertDTO dessertDTO) {
        Dessert dessert = new Dessert();
        dessert.setId(dessertDTO.getId());
        dessert.setName(dessertDTO.getName());
        dessert.setPrice(dessertDTO.getPrice());
        dessert.setFlavor(dessertDTO.getFlavor());
        dessert.setCuisineId(dessertDTO.getCuisineId());
        return dessert;
    }

    public static DessertDTO mapToDessertDTO(Dessert dessert) {
        DessertDTO dessertDTO = new DessertDTO();
        dessertDTO.setId(dessert.getId());
        dessertDTO.setName(dessert.getName());
        dessertDTO.setPrice(dessert.getPrice());
        dessertDTO.setFlavor(dessert.getFlavor());
        dessertDTO.setCuisineId(dessert.getCuisineId());
        return dessertDTO;
    }
}
