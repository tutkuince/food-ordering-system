package com.incetutku.foodorderingsystem.controller;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.dto.OrderDTO;
import com.incetutku.foodorderingsystem.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    private OrderDTO orderDTO;

    @BeforeEach
    void setUp() {
        Set<DessertDTO> dessertDTOs = Set.of(new DessertDTO("Sernik", 5.99, "Creamy, cheesy, slightly sweet.", 1L));
        Set<DrinkDTO> drinkDTOs = Set.of(new DrinkDTO("Pepsi", 3.50, true, true));
        Set<MainCourseDTO> mainCourseDTOs = Set.of(new MainCourseDTO("Pierogi", 8.99, false, 1L));
        orderDTO = new OrderDTO(dessertDTOs, drinkDTOs, mainCourseDTOs);
    }

    @DisplayName("JUnit test for create Order REST API")
    @Test
    void givenOrderDTOObject_whenSaveOrderDTO_thenReturnOrderDTOObject() {
        // given - precondition or setup
        when(orderService.save(orderDTO)).thenReturn(orderDTO);

        // when - action or the behaviour that we are going to test
        ResponseEntity<OrderDTO> response = orderController.createOrder(orderDTO);

        // then - verify the output
        verify(orderService, times(1)).save(orderDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(orderDTO, response.getBody());
    }
}