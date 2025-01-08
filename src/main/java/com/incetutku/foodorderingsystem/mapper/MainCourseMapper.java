package com.incetutku.foodorderingsystem.mapper;

import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.entity.MainCourse;

public class MainCourseMapper {

    private MainCourseMapper() {
    }

    public static MainCourse mapToMainCourse(MainCourseDTO mainCourseDTO) {
        MainCourse mainCourse = new MainCourse();
        mainCourse.setId(mainCourseDTO.getId());
        mainCourse.setName(mainCourseDTO.getName());
        mainCourse.setPrice(mainCourseDTO.getPrice());
        mainCourse.setSpicy(mainCourseDTO.isSpicy());
        mainCourse.setCuisineId(mainCourseDTO.getCuisineId());
        return mainCourse;
    }

    public static MainCourseDTO mapToMainCourseDTO(MainCourse mainCourse) {
        MainCourseDTO mainCourseDTO = new MainCourseDTO();
        mainCourseDTO.setId(mainCourse.getId());
        mainCourseDTO.setName(mainCourse.getName());
        mainCourseDTO.setPrice(mainCourse.getPrice());
        mainCourseDTO.setSpicy(mainCourse.isSpicy());
        mainCourseDTO.setCuisineId(mainCourse.getCuisineId());
        return mainCourseDTO;
    }
}
