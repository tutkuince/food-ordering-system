package com.incetutku.foodorderingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDTO {
    private Long id;
    private String orderTime;
    private double totalPrice;
    private Set<DessertDTO> dessertDTOs;
    private Set<DrinkDTO> drinkDTOs;
    private Set<MainCourseDTO> mainCourseDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<DessertDTO> getDessertDTOs() {
        return dessertDTOs;
    }

    public void setDessertDTOs(Set<DessertDTO> dessertDTOs) {
        this.dessertDTOs = dessertDTOs;
    }

    public Set<DrinkDTO> getDrinkDTOs() {
        return drinkDTOs;
    }

    public void setDrinkDTOs(Set<DrinkDTO> drinkDTOs) {
        this.drinkDTOs = drinkDTOs;
    }

    public Set<MainCourseDTO> getMainCourseDTOs() {
        return mainCourseDTOs;
    }

    public void setMainCourseDTOs(Set<MainCourseDTO> mainCourseDTOs) {
        this.mainCourseDTOs = mainCourseDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n orderTime='" + orderTime + '\'' +
                "\n totalPrice=" + totalPrice + " PLN" +
                "\n mainCourses=" + mainCourseDTOs +
                "\n desserts=" + dessertDTOs +
                "\n drinks=" + drinkDTOs +
                '}';
    }
}
