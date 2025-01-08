package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.service.DessertService;
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
class DessertControllerTest {

    @InjectMocks
    private DessertController dessertController;

    @Mock
    private DessertService dessertService;

    private DessertDTO dessertDTO;

    @BeforeEach
    void setUp() {
        dessertDTO = new DessertDTO("Sernik", 5.99, "Creamy, cheesy, slightly sweet.", 1L);
    }

    @DisplayName("JUnit test for create Dessert REST API")
    @Test
    void givenDessertDTOObject_whenSaveDessert_thenReturnDessertDTOObject() {
        // given - precondition or setup
        when(dessertService.save(dessertDTO)).thenReturn(dessertDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<DessertDTO> response = dessertController.createDessert(dessertDTO);

        // then - verify the output
        verify(dessertService, times(1)).save(dessertDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(dessertDTO, response.getBody());
    }

    @DisplayName("JUnit test for get all desserts REST API")
    @Test
    void givenDessertDTOList_whenGetAllDesserts_thenReturnDessertDTOList() {
        // given - precondition or setup
        DessertDTO dessertDTO1 = new DessertDTO("Pączki", 3.49, "Sweet, fluffy, with a fruity or custard filling.", 1L);
        when(dessertService.getAllDesserts()).thenReturn(List.of(dessertDTO, dessertDTO1));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<DessertDTO>> response = dessertController.getAllDesserts();

        // then - verify the output
        verify(dessertService, times(1)).getAllDesserts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(dessertDTO, dessertDTO1), response.getBody());
    }

    @DisplayName("JUnit test for get desserts by cuisine Id REST API")
    @Test
    void givenCuisineId_whenGetDessertsById_thenReturnDessertListDTO() {
        // given - precondition or setup
        long id = 1L;
        when(dessertService.getDessertsByCuisineId(id)).thenReturn(List.of(dessertDTO));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<DessertDTO>> response = dessertController.getDessertsByCuisineId(id);

        // then - verify the output
        verify(dessertService, times(1)).getDessertsByCuisineId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(dessertDTO), response.getBody());
    }
}