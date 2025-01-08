package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.dto.OrderDTO;
import com.incetutku.foodorderingsystem.entity.Order;
import com.incetutku.foodorderingsystem.mapper.OrderMapper;
import com.incetutku.foodorderingsystem.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private OrderDTO orderDTOWithAllTypesOfProducts;
    private OrderDTO orderDTOWithMainCourseAndDessert;
    private OrderDTO orderDTOWithDrink;

    @BeforeEach
    void setUp() {
        Set<DessertDTO> dessertDTOs = Set.of(new DessertDTO("Sernik", 5.99, "Creamy, cheesy, slightly sweet.", 1L));
        Set<DrinkDTO> drinkDTOs = Set.of(new DrinkDTO("Pepsi", 3.50, true, true));
        Set<MainCourseDTO> mainCourseDTOs = Set.of(new MainCourseDTO("Pierogi", 8.99, false, 1L));
        orderDTOWithAllTypesOfProducts = new OrderDTO(dessertDTOs, drinkDTOs, mainCourseDTOs);
        orderDTOWithMainCourseAndDessert = new OrderDTO(dessertDTOs, null, mainCourseDTOs);
        orderDTOWithDrink = new OrderDTO(null, drinkDTOs, null);
    }

    @DisplayName("Junit test for save Order with all products")
    @Test
    void givenOrderWithAllTypesOfProduct_whenSaveOrder_thenReturnOrderObject() {
        // given - precondition or setup
        Order orderToBeSaved = OrderMapper.mapToOrder(orderDTOWithAllTypesOfProducts);

        when(orderRepository.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        // when - action or the behaviour that we are going to test
        OrderDTO savedOrderDTO = orderService.save(orderDTOWithAllTypesOfProducts);

        // then - verify the output
        assertThat(savedOrderDTO).isNotNull();
    }

    @DisplayName("Junit test for save Order with main course and dessert")
    @Test
    void givenOrderWithMainCourseAndDessert_whenSaveOrder_thenReturnOrderObject() {
        // given - precondition or setup
        Order orderToBeSaved = OrderMapper.mapToOrder(orderDTOWithMainCourseAndDessert);

        when(orderRepository.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        // when - action or the behaviour that we are going to test
        OrderDTO savedOrderDTO = orderService.save(orderDTOWithAllTypesOfProducts);

        // then - verify the output
        assertThat(savedOrderDTO).isNotNull();
    }

    @DisplayName("Junit test for save Order with drink")
    @Test
    void givenOrderWithDrink_whenSaveOrder_thenReturnOrderObject() {
        // given - precondition or setup
        Order orderToBeSaved = OrderMapper.mapToOrder(orderDTOWithDrink);

        when(orderRepository.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        // when - action or the behaviour that we are going to test
        OrderDTO savedOrderDTO = orderService.save(orderDTOWithAllTypesOfProducts);

        // then - verify the output
        assertThat(savedOrderDTO).isNotNull();
    }
}