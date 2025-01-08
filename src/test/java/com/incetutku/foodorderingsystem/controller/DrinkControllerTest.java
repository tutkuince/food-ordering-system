package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.service.DrinkService;
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
class DrinkControllerTest {

    @InjectMocks
    private DrinkController drinkController;

    @Mock
    private DrinkService drinkService;

    private DrinkDTO drinkDTO;

    @BeforeEach
    void setUp() {
        drinkDTO = new DrinkDTO("Pepsi", 3.50, true, true);
    }

    @DisplayName("JUnit test for create Drink REST API")
    @Test
    void givenDrinkDTOObject_whenSaveDrinkDTO_thenReturnDrinkDTOObject() throws Exception {
        // given - precondition or setup
        when(drinkService.save(drinkDTO)).thenReturn(drinkDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<DrinkDTO> response = drinkController.createDrink(drinkDTO);

        // then - verify the output
        verify(drinkService, times(1)).save(drinkDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(drinkDTO, response.getBody());
    }

    @DisplayName("Junit test for get all drinks REST API")
    @Test
    void givenDrinkDTOList_whenGetAllDrinks_thenReturnDrinkDTOList() {
        // given - precondition or setup
        DrinkDTO drinkDTO1 = new DrinkDTO("Orange Juice", 3.00, true, false);
        when(drinkService.getAllDrinks()).thenReturn(List.of(drinkDTO, drinkDTO1));

        // when - action or the behaviour that we are going to test
        ResponseEntity<List<DrinkDTO>> response = drinkController.getAllDrinks();

        // then - verify the output
        verify(drinkService, times(1)).getAllDrinks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(drinkDTO, drinkDTO1), response.getBody());
    }

    @DisplayName("Junit test for get drink by id REST API")
    @Test
    void givenDrinkId_whenGetDrinkById_thenReturnDrinkDTO() {
        // given - precondition or setup
        long id = 1L;
        when(drinkService.getDrinkById(id)).thenReturn(drinkDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<DrinkDTO> response = drinkController.getDrinkById(id);

        // then - verify the output
        verify(drinkService, times(1)).getDrinkById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(drinkDTO, response.getBody());
    }
}