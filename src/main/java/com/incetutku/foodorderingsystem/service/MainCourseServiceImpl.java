package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.entity.MainCourse;
import com.incetutku.foodorderingsystem.mapper.MainCourseMapper;
import com.incetutku.foodorderingsystem.repository.MainCourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class MainCourseServiceImpl implements MainCourseService {
    private final MainCourseRepository mainCourseRepository;
    private final CuisineService cuisineService;

    public MainCourseServiceImpl(MainCourseRepository mainCourseRepository, CuisineService cuisineService) {
        this.mainCourseRepository = mainCourseRepository;
        this.cuisineService = cuisineService;
    }

    @Override
    @Transactional
    public MainCourseDTO save(MainCourseDTO mainCourseDTO) {
        MainCourse savableMainCourse = MainCourseMapper.mapToMainCourse(mainCourseDTO);
        MainCourse savedMainCourse = mainCourseRepository.save(savableMainCourse);
        MainCourseDTO savedMainCourseDto = MainCourseMapper.mapToMainCourseDTO(savedMainCourse);
        CuisineDTO selectedCuisine = cuisineService.getById(mainCourseDTO.getCuisineId());
        Set<MainCourseDTO> mainCourseDTOS = selectedCuisine.getMainCourseDTOS();
        mainCourseDTOS.add(savedMainCourseDto);
        cuisineService.save(selectedCuisine);
        return MainCourseMapper.mapToMainCourseDTO(savedMainCourse);
    }

    @Override
    public List<MainCourseDTO> getMainCoursesByCuisineId(Long cuisineId) {
        List<MainCourse> mainCoursesByCuisineId = mainCourseRepository.findMainCoursesByCuisineId(cuisineId);
        return mainCoursesByCuisineId.stream().map(MainCourseMapper::mapToMainCourseDTO).toList();
    }

    @Override
    public List<MainCourseDTO> getMainAllCourses() {
        return mainCourseRepository.findAll().stream().map(MainCourseMapper::mapToMainCourseDTO).toList();
    }

    @Override
    public MainCourseDTO getMainCourseById(Long id) {
        MainCourse selectedMainCourse = mainCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Main Course not found"));
        return MainCourseMapper.mapToMainCourseDTO(selectedMainCourse);
    }
}
