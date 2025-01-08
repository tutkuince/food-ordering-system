package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.service.CuisineService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuisineControllerTest {

    @InjectMocks
    private CuisineController cuisineController;

    @Mock
    private CuisineService cuisineService;

    private CuisineDTO cuisineDTO;

    @BeforeEach
    void setUp() {
        cuisineDTO = new CuisineDTO("Polish", "Desc");
    }

    @DisplayName("JUnit test for create Cuisine REST API")
    @Test
    void givenCuisineDTOObject_whenSaveCuisineDTO_thenReturnCuisineDTOObject() {
        // given - precondition or setup
        when(cuisineService.save(cuisineDTO)).thenReturn(cuisineDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<CuisineDTO> response = cuisineController.createCuisine(cuisineDTO);

        // then - verify the output
        verify(cuisineService, times(1)).save(cuisineDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cuisineDTO, response.getBody());
    }

    @DisplayName("JUnit test for get all Cuisines REST API")
    @Test
    void givenCuisineDTOList_whenGetAllCuisines_thenReturnCuisineDTOList() {
        // given - precondition or setup
        CuisineDTO cuisineDTO1 = new CuisineDTO("Polish", "Desc");
        when(cuisineService.getAll()).thenReturn(List.of(cuisineDTO, cuisineDTO1));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<CuisineDTO>> response = cuisineController.getAllCuisines();

        // then - verify the output
        verify(cuisineService, times(1)).getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(cuisineDTO, cuisineDTO1), response.getBody());
    }
}