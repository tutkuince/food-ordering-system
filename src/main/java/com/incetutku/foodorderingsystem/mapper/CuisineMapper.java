package com.incetutku.foodorderingsystem.mapper;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.entity.Cuisine;
import com.incetutku.foodorderingsystem.entity.Dessert;
import com.incetutku.foodorderingsystem.entity.MainCourse;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CuisineMapper {
    private CuisineMapper() {
    }

    public static Cuisine toMapCuisine(CuisineDTO cuisineDTO) {
        Cuisine cuisine = new Cuisine();
        cuisine.setId(cuisineDTO.getId());
        cuisine.setName(cuisineDTO.getName());
        cuisine.setDesc(cuisineDTO.getDesc());
        if (!Objects.isNull(cuisineDTO.getMainCourseDTOS())) {
            Set<MainCourse> mainCourses = cuisineDTO.getMainCourseDTOS().stream().map(MainCourseMapper::mapToMainCourse).collect(Collectors.toSet());
            cuisine.setMainCourses(mainCourses);
        }
        if (!Objects.isNull(cuisineDTO.getDessertDTOS())) {
            Set<Dessert> desserts = cuisineDTO.getDessertDTOS().stream().map(DessertMapper::mapToDessert).collect(Collectors.toSet());
            cuisine.setDesserts(desserts);
        }
        return cuisine;
    }

    public static CuisineDTO toMapCuisineDTO(Cuisine cuisine) {
        CuisineDTO cuisineDTO = new CuisineDTO();
        cuisineDTO.setId(cuisine.getId());
        cuisineDTO.setName(cuisine.getName());
        cuisineDTO.setDesc(cuisine.getDesc());
        if (!Objects.isNull(cuisine.getMainCourses())) {
            Set<MainCourseDTO> mainCourses = cuisine.getMainCourses().stream().map(MainCourseMapper::mapToMainCourseDTO).collect(Collectors.toSet());
            cuisineDTO.setMainCourseDTOS(mainCourses);
        }
        if (!Objects.isNull(cuisine.getDesserts())) {
            Set<DessertDTO> desserts = cuisine.getDesserts().stream().map(DessertMapper::mapToDessertDTO).collect(Collectors.toSet());
            cuisineDTO.setDessertDTOS(desserts);
        }
        return cuisineDTO;
    }
}
