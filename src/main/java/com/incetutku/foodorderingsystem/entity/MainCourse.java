package com.incetutku.foodorderingsystem.entity;

import jakarta.persistence.Entity;

@Entity
public class MainCourse extends MenuItem {
    private boolean spicy;
    private Long cuisineId;

    public MainCourse() {
        super();
    }

    public MainCourse(String name, double price, boolean spicy, Long cuisineId) {
        super(name, price);
        this.spicy = spicy;
        this.cuisineId = cuisineId;
    }

    public MainCourse(Long id, String name, double price, boolean spicy, Long cuisineId) {
        super(id, name, price);
        this.spicy = spicy;
        this.cuisineId = cuisineId;
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
    public String toString() {
        return "MainCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isSpicy=" + spicy +
                ", cuisineId=" + cuisineId +
                '}';
    }
}