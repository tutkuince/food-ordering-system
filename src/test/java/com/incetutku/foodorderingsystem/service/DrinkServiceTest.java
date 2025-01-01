package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.entity.Drink;
import com.incetutku.foodorderingsystem.mapper.DrinkMapper;
import com.incetutku.foodorderingsystem.repository.DrinkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DrinkServiceTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkService;

    private DrinkDTO drinkDTO;

    @BeforeEach
    void setUp() {
        drinkDTO = new DrinkDTO("Pepsi", 3.50, true, true);
    }

    @DisplayName("Junit Test for Save Drink")
    @Test
    void givenDrinkObject_whenSaveDrink_thenReturnDrinkObject() {
        // given - precondition or setup
        Drink drinkToBeSaved = DrinkMapper.mapToDrink(drinkDTO);

        when(drinkRepository.save(drinkToBeSaved)).thenReturn(drinkToBeSaved);

        // when - action or the behaviour that we are going to test
        DrinkDTO savedDrinkDTO = drinkService.save(drinkDTO);

        // then - verify the output
        assertThat(savedDrinkDTO).isNotNull();
    }

    @DisplayName("Junit test for get all drinks")
    @Test
    void givenDrinkList_whenGetAllDrinks_thenReturnDrinkList() {
        // given - precondition or setup
        Drink drinkToBeSave1 = DrinkMapper.mapToDrink(drinkDTO);
        DrinkDTO drinkDTO1 = new DrinkDTO("Orange Juice", 3.00, true, false);
        Drink drinkToBeSave2 = DrinkMapper.mapToDrink(drinkDTO1);
        when(drinkRepository.findAll()).thenReturn(List.of(drinkToBeSave1, drinkToBeSave2));

        // when - action or the behaviour that we are going to test
        List<DrinkDTO> drinks = drinkService.getAllDrinks();

        // then - verify the output
        assertThat(drinks).isNotNull();
        assertThat(drinks).size().isEqualTo(2);
    }

    @DisplayName("Junit test for get all drinks")
    @Test
    void givenEmptyDrinkList_whenGetAllDrinks_thenReturnEmptyDrinkList() {
        // given - precondition or setup
        when(drinkRepository.findAll()).thenReturn(Collections.emptyList());

        // when - action or the behaviour that we are going to test
        List<DrinkDTO> drinks = drinkService.getAllDrinks();

        // then - verify the output
        assertThat(drinks).isEmpty();
        assertThat(drinks).size().isEqualTo(0);
    }

    @DisplayName("JUnit test for get drink by Id")
    @Test
    void givenDrinkId_whenGetDrinkById_thenReturnDrink() {
        // given - precondition or setup
        Drink selectedDrink = DrinkMapper.mapToDrink(drinkDTO);
        when(drinkRepository.findById(1L)).thenReturn(Optional.of(selectedDrink));

        // when - action or the behaviour that we are going to test
        DrinkDTO drinkById = drinkService.getDrinkById(1L);

        // then - verify the output
        assertThat(drinkById).isNotNull();
    }

    @DisplayName("JUnit test for get drink by Id")
    @Test
    void givenNonExistingDrinkId_whenGetDrinkById_thenThrowsRuntimeException() {
        // given - precondition or setup
        when(drinkRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> drinkService.getDrinkById(1L));
    }
}