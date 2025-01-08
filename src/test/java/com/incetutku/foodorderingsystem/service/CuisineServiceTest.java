package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.entity.Cuisine;
import com.incetutku.foodorderingsystem.mapper.CuisineMapper;
import com.incetutku.foodorderingsystem.repository.CuisineRepository;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CuisineServiceTest {

    @Mock
    private CuisineRepository cuisineRepository;

    @InjectMocks
    private CuisineServiceImpl cuisineService;

    private CuisineDTO cuisineDTO;

    @BeforeEach
    void setUp() {
        cuisineDTO = new CuisineDTO("Polish", "Desc");
    }

    @DisplayName("JUnit Test for save cuisine")
    @Test
    void givenCuisineObject_whenSaveCuisine_thenReturnCuisineObject() {
        // given - precondition or setup
        Cuisine cuisineToBeSaved = CuisineMapper.toMapCuisine(cuisineDTO);

        when(cuisineRepository.save(any())).thenReturn(cuisineToBeSaved);

        // when - action or the behaviour that we are going to test
        CuisineDTO savedCuisineDTO = cuisineService.save(cuisineDTO);

        // then - verify the output
        assertThat(savedCuisineDTO).isNotNull();
    }

    @DisplayName("JUnit test for get all cuisines")
    @Test
    void givenCuisineList_whenGetAllCuisines_thenReturnCuisineList() {
        // given - precondition or setup
        Cuisine cuisineToBeSave1 = CuisineMapper.toMapCuisine(cuisineDTO);
        CuisineDTO cuisineDTO1 = new CuisineDTO("Mexican", "Desc");
        Cuisine cuisineToBeSave2 = CuisineMapper.toMapCuisine(cuisineDTO1);

        when(cuisineRepository.findAll()).thenReturn(List.of(cuisineToBeSave1, cuisineToBeSave2));

        // when - action or the behaviour that we are going to test
        List<CuisineDTO> cuisines = cuisineService.getAll();

        // then - verify the output
        assertThat(cuisines).isNotNull();
        assertThat(cuisines).size().isEqualTo(2);
    }

    @DisplayName("JUnit test for get cuisine by Id")
    @Test
    void givenCuisineId_whenGetCuisineById_thenReturnCuisine() {
        // given - precondition or setup
        Cuisine selectedCuisine = CuisineMapper.toMapCuisine(cuisineDTO);
        when(cuisineRepository.findById(1L)).thenReturn(Optional.of(selectedCuisine));

        // when - action or the behaviour that we are going to test
        CuisineDTO cuisineById = cuisineService.getById(1L);

        // then - verify the output
        assertThat(cuisineById).isNotNull();
    }

    @DisplayName("JUnit test for get cuisine by Id - Throws Runtime Exception")
    @Test
    void givenNonExistingCuisineId_whenGetCuisineById_thenThrowsRuntimeException() {
        // given - precondition or setup
        when(cuisineRepository.findById(1L)).thenReturn(Optional.empty());

        // when - action or the behaviour that we are going to test
        // then - verify the output
        assertThrows(RuntimeException.class, () -> cuisineService.getById(1L));
    }
}