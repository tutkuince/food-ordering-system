package com.incetutku.foodorderingsystem.repository;

import com.incetutku.foodorderingsystem.entity.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainCourseRepository extends JpaRepository<MainCourse, Long> {
    List<MainCourse> findMainCoursesByCuisineId(Long cuisineId);
}
