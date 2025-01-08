package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.MainCourseDTO;

import java.util.List;

public interface MainCourseService {
    MainCourseDTO save(MainCourseDTO mainCourseDTO);

    MainCourseDTO getMainCourseById(Long id);

    List<MainCourseDTO> getMainCoursesByCuisineId(Long cuisineId);

    List<MainCourseDTO> getMainAllCourses();

}
