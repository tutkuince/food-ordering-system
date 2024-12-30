package com.incetutku.foodorderingsystem.dto;

import java.util.Objects;

public class MainCourseDTO {
    private long id;
    private String name;
    private double price;
    private boolean spicy;
    private Long cuisineId;

    public MainCourseDTO() {
    }

    public MainCourseDTO(String name, double price, boolean spicy, Long cuisineId) {
        this.name = name;
        this.price = price;
        this.spicy = spicy;
        this.cuisineId = cuisineId;
    }

    public MainCourseDTO(long id, String name, double price, boolean spicy, Long cuisineId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.spicy = spicy;
        this.cuisineId = cuisineId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainCourseDTO that = (MainCourseDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MainCourseDTO{" +
                "name='" + name + '\'' +
                "(isSpicy=" + spicy +
                "), price=" + price +
                '}';
    }
}
