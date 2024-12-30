package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.service.MainCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/main-courses")
public class MainCourseController {
    private final MainCourseService mainCourseService;

    public MainCourseController(MainCourseService mainCourseService) {
        this.mainCourseService = mainCourseService;
    }

    @PostMapping
    public ResponseEntity<MainCourseDTO> createMainCourse(@RequestBody MainCourseDTO mainCourseDTO) {
        return new ResponseEntity<>(mainCourseService.save(mainCourseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MainCourseDTO>> getAllMainCourses() {
        return ResponseEntity.ok(mainCourseService.getMainAllCourses());
    }

    @GetMapping("/{cuisineId}")
    public ResponseEntity<List<MainCourseDTO>> getMainCourseByCuisineId(@PathVariable Long cuisineId) {
        return ResponseEntity.ok(mainCourseService.getMainCoursesByCuisineId(cuisineId));
    }
}
