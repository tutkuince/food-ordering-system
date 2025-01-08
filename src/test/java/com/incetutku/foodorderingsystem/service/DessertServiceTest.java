package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.CuisineDTO;
import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.entity.Cuisine;
import com.incetutku.foodorderingsystem.entity.Dessert;
import com.incetutku.foodorderingsystem.mapper.CuisineMapper;
import com.incetutku.foodorderingsystem.mapper.DessertMapper;
import com.incetutku.foodorderingsystem.repository.CuisineRepository;
import com.incetutku.foodorderingsystem.repository.DessertRepository;
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
class DessertServiceTest {

    @Mock
    private DessertRepository dessertRepository;
    @Mock
    private CuisineRepository cuisineRepository;
    @Mock
    private CuisineServiceImpl cuisineService;

    @InjectMocks
    private DessertServiceImpl dessertService;


    private DessertDTO dessertDTO;

    @BeforeEach
    void setUp() {
        dessertDTO = new DessertDTO("Sernik", 5.99, "Creamy, cheesy, slightly sweet.", 1L);
    }

    @DisplayName("JUnit Test for save Dessert")
    @Test
    void givenDessertObject_whenSaveDessert_thenReturnDessertObject() {
        // given - precondition or setup
        Dessert dessertToBeSaved = DessertMapper.mapToDessert(dessertDTO);
        CuisineDTO cuisineDTO = new CuisineDTO("Polish", "Desc");
        Cuisine cuisineToBeSaved = CuisineMapper.toMapCuisine(cuisineDTO);

        when(dessertRepository.save(dessertToBeSaved)).thenReturn(dessertToBeSaved);
        lenient().when(cuisineRepository.findById(1L)).thenReturn(Optional.of(cuisineToBeSaved));
        when(cuisineService.getById(1L)).thenReturn(cuisineDTO);

        // when - action or behavior that we are going to test
        DessertDTO savedDessertDTO = dessertService.save(dessertDTO);

        // then - verify the output
        assertThat(savedDessertDTO).isNotNull();
    }

    @DisplayName("JUnit test for get all desserts")
    @Test
    void givenDessertList_whenGetAllDesserts_thenReturnDessertList() {
        // given - precondition or setup
        Dessert dessertToBeSaved1 = DessertMapper.mapToDessert(dessertDTO);
        DessertDTO dessertDTO1 = new DessertDTO("Pączki", 3.49, "Sweet, fluffy, with a fruity or custard filling.", 1L);
        Dessert dessertToBeSaved2 = DessertMapper.mapToDessert(dessertDTO1);

        when(dessertRepository.findAll()).thenReturn(List.of(dessertToBeSaved1, dessertToBeSaved2));

        // when - action or the behaviour that we are going to test
        List<DessertDTO> desserts = dessertService.getAllDesserts();

        // then - verify the output
        assertThat(desserts).isNotNull();
        assertThat(desserts).size().isEqualTo(2);
    }

    @DisplayName("JUnit test for get dessert by Id")
    @Test
    void givenDessertId_whenGetDessertById_thenReturnDessert() {
        // given - precondition or setup
        Dessert selectedDessert = DessertMapper.mapToDessert(dessertDTO);
        when(dessertRepository.findById(1L)).thenReturn(Optional.of(selectedDessert));

        // when - action or the behaviour that we are going to test
        DessertDTO dessertById = dessertService.getDessertById(1L);

        // then - verify the output
        assertThat(dessertById).isNotNull();
    }

    @DisplayName("JUnit test for get dessert by Id - Throws Runtime Exception")
    @Test
    void givenNonExistingDessertId_whenGetDessertById_thenThrowsRuntimeException() {
        // given - precondition or setup
        when(dessertRepository.findById(1L)).thenReturn(Optional.empty());

        // when - action or the behaviour that we are going to test
        // then - verify the output
        assertThrows(RuntimeException.class, () -> dessertService.getDessertById(1L));
    }

    @DisplayName("Description")
    @Test
    void givenCuisineId_whenGetDessertsByCuisineId_thenReturnDessertList() {
        // given - precondition or setup
        Dessert dessert1 = DessertMapper.mapToDessert(dessertDTO);
        DessertDTO dessertDTO1 = new DessertDTO("Makowiec", 4.99, "Nutty, sweet, with a hint of poppy seeds.", 1L);
        Dessert dessert2 = DessertMapper.mapToDessert(dessertDTO1);

        when(dessertRepository.findDessertsByCuisineId(1L)).thenReturn(List.of(dessert1, dessert2));

        // when - action or the behaviour that we are going to test
        List<DessertDTO> dessertsByCuisineId = dessertService.getDessertsByCuisineId(1L);

        // then - verify the output
        assertThat(dessertsByCuisineId).isNotNull();
        assertThat(dessertsByCuisineId).size().isEqualTo(2);
    }

}