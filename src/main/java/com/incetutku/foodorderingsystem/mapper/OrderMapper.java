package com.incetutku.foodorderingsystem.mapper;

import com.incetutku.foodorderingsystem.dto.OrderDTO;
import com.incetutku.foodorderingsystem.entity.Order;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderMapper {
    private OrderMapper() {
    }

    public static Order mapToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setTotalPrice(BigDecimal.valueOf(orderDTO.getTotalPrice()));
        order.setDesserts(mapCollection(orderDTO.getDessertDTOs(), DessertMapper::mapToDessert));
        order.setDrinks(mapCollection(orderDTO.getDrinkDTOs(), DrinkMapper::mapToDrink));
        order.setMainCourses(mapCollection(orderDTO.getMainCourseDTOs(), MainCourseMapper::mapToMainCourse));
        return order;
    }

    public static OrderDTO mapToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderTime(order.getOrderTime().toString());
        orderDTO.setTotalPrice(order.getTotalPrice().doubleValue());
        orderDTO.setDessertDTOs(mapCollection(order.getDesserts(), DessertMapper::mapToDessertDTO));
        orderDTO.setDrinkDTOs(mapCollection(order.getDrinks(), DrinkMapper::mapToDrinkDTO));
        orderDTO.setMainCourseDTOs(mapCollection(order.getMainCourses(), MainCourseMapper::mapToMainCourseDTO));
        return orderDTO;
    }

    private static <T, R> Set<R> mapCollection(Set<T> source, Function<T, R> mapper) {
        return source != null ? source.stream().map(mapper).collect(Collectors.toSet()) : Collections.emptySet();
    }
}
