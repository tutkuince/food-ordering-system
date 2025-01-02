package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.service.MainCourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainCourseControllerTest {

    @InjectMocks
    private MainCourseController mainCourseController;

    @Mock
    private MainCourseService mainCourseService;

    private MainCourseDTO mainCourseDTO;

    @BeforeEach
    void setUp() {
        mainCourseDTO = new MainCourseDTO("Pierogi", 8.99, false, 1L);
    }

    @DisplayName("JUnit test for create Main Course REST API")
    @Test
    void givenCuisineDTOObject_whenSaveCuisineDTO_thenReturnCuisineDTOObject() {
        // given - precondition or setup
        when(mainCourseService.save(mainCourseDTO)).thenReturn(mainCourseDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<MainCourseDTO> response = mainCourseController.createMainCourse(mainCourseDTO);

        // then - verify the output
        verify(mainCourseService, times(1)).save(mainCourseDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mainCourseDTO, response.getBody());
    }

    @DisplayName("JUnit test for get all Main Courses REST API")
    @Test
    void givenMainCourseDTOList_whenGetAllMainCourses_thenReturnMainCourseDTOList() {
        // given - precondition or setup
        MainCourseDTO mainCourseDTO1 = new MainCourseDTO("Pierogi", 8.99, false, 1L);
        when(mainCourseService.getMainAllCourses()).thenReturn(List.of(mainCourseDTO, mainCourseDTO1));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<MainCourseDTO>> response = mainCourseController.getAllMainCourses();

        // then - verify the output
        verify(mainCourseService, times(1)).getMainAllCourses();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(mainCourseDTO, mainCourseDTO1), response.getBody());
    }

    @DisplayName("JUnit test for get main courses by cuisine Id REST API")
    @Test
    void givenCuisineId_whenGetMainCourseByCuisineId_thenReturnMainCourseListDTO() {
        // given - precondition or setup
        long id = 1L;
        when(mainCourseService.getMainCoursesByCuisineId(id)).thenReturn(List.of(mainCourseDTO));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<MainCourseDTO>> response = mainCourseController.getMainCourseByCuisineId(id);

        // then - verify the output
        verify(mainCourseService, times(1)).getMainCoursesByCuisineId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(mainCourseDTO), response.getBody());
    }
}