package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.entity.Cuisine;
import com.incetutku.foodorderingsystem.entity.MainCourse;
import com.incetutku.foodorderingsystem.mapper.CuisineMapper;
import com.incetutku.foodorderingsystem.mapper.MainCourseMapper;
import com.incetutku.foodorderingsystem.repository.CuisineRepository;
import com.incetutku.foodorderingsystem.repository.MainCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainCourseServiceTest {

    @Mock
    private MainCourseRepository mainCourseRepository;
    @Mock
    private CuisineRepository cuisineRepository;
    @Mock
    private CuisineServiceImpl cuisineService;

    @InjectMocks
    private MainCourseServiceImpl mainCourseService;

    private MainCourseDTO mainCourseDTO;

    @BeforeEach
    void setUp() {
        mainCourseDTO = new MainCourseDTO("Pierogi", 8.99, false, 1L);
    }

    // TODO
    @DisplayName("JUnit Test for save Main Course")
    @Test
    void givenMainCourseObject_whenSaveMainCourse_thenReturnMainCourseObject() {
        // given - precondition or setup
        MainCourse mainCourseToBeSaved = MainCourseMapper.mapToMainCourse(mainCourseDTO);
        CuisineDTO cuisineDTO = new CuisineDTO("Polish", "Desc");
        Cuisine cuisineToBeSaved = CuisineMapper.toMapCuisine(cuisineDTO);

        when(mainCourseRepository.save(mainCourseToBeSaved)).thenReturn(mainCourseToBeSaved);
        lenient().when(cuisineRepository.findById(1L)).thenReturn(Optional.of(cuisineToBeSaved));
        when(cuisineService.getById(1L)).thenReturn(cuisineDTO);

        // when - action or the behaviour that we are going to test
        MainCourseDTO savedMainCourseDTO = mainCourseService.save(mainCourseDTO);

        // then - verify the output
        assertThat(savedMainCourseDTO).isNotNull();
    }

    @DisplayName("JUnit test for get main course by Id")
    @Test
    void givenMainCourseId_whenGetMainCourseById_thenReturnMainCourse() {
        // given - precondition or setup
        MainCourse selectedMainCourse = MainCourseMapper.mapToMainCourse(mainCourseDTO);
        when(mainCourseRepository.findById(1L)).thenReturn(Optional.of(selectedMainCourse));

        // when - action or the behaviour that we are going to test
        MainCourseDTO mainCourseById = mainCourseService.getMainCourseById(1L);

        // then - verify the output
        assertThat(mainCourseById).isNotNull();
    }

    @DisplayName("JUnit test for get main course by Id - throws exception")
    @Test
    void givenNonExistingMainCourseId_whenGetMainCourseById_thenThrowsRuntimeException() {
        // given - precondition or setup
        when(mainCourseRepository.findById(1L)).thenReturn(Optional.empty());

        // when - action or the behaviour that we are going to test
        // then - verify the output
        assertThrows(RuntimeException.class, () -> mainCourseService.getMainCourseById(1L));
    }
    
    @DisplayName("JUnit test for get all main courses")
    @Test
    void givenMainCourseList_whenGetAllMainCourses_thenReturnMainCourseList() {
        // given - precondition or setup
        MainCourse mainCourseToBeSaved1 = MainCourseMapper.mapToMainCourse(mainCourseDTO);
        MainCourseDTO mainCourseDTO1 = new MainCourseDTO("Pierogi", 8.99, false, 1L);
        MainCourse mainCourseToBeSaved2 = MainCourseMapper.mapToMainCourse(mainCourseDTO1);

        when(mainCourseRepository.findAll()).thenReturn(List.of(mainCourseToBeSaved1, mainCourseToBeSaved2));

        // when - action or the behaviour that we are going to test
        List<MainCourseDTO> mainAllCourses = mainCourseService.getMainAllCourses();

        // then - verify the output
        assertThat(mainAllCourses).isNotNull();
        assertThat(mainAllCourses).size().isEqualTo(2);
    }

    @DisplayName("JUnit test for get all main courses by Cuisine Id")
    @Test
    void givenCuisineId_whenGetAllMainCoursesByCuisineId_thenReturnMainCourseList() {
        // given - precondition or setup
        MainCourse mainCourse1 = MainCourseMapper.mapToMainCourse(mainCourseDTO);
        MainCourseDTO mainCourseDTO1 = new MainCourseDTO("Pierogi", 8.99, false, 1L);
        MainCourse mainCourse2 = MainCourseMapper.mapToMainCourse(mainCourseDTO1);

        when(mainCourseRepository.findMainCoursesByCuisineId(1L)).thenReturn(List.of(mainCourse1, mainCourse2));

        // when - action or the behaviour that we are going to test
        List<MainCourseDTO> mainAllCourses = mainCourseService.getMainCoursesByCuisineId(1L);

        // then - verify the output
        assertThat(mainAllCourses).isNotNull();
        assertThat(mainAllCourses).size().isEqualTo(2);
    }
}