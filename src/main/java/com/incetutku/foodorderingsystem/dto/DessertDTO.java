package com.incetutku.foodorderingsystem.dto;

import java.util.Objects;

public class DessertDTO {
    private Long id;
    private String name;
    private double price;
    private String flavor;
    private Long cuisineId;

    public DessertDTO() {
    }

    public DessertDTO(String name, double price, String flavor, Long cuisineId) {
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.cuisineId = cuisineId;
    }

    public DessertDTO(Long id, String name, double price, String flavor, Long cuisineId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.cuisineId = cuisineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
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
        DessertDTO that = (DessertDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DessertDTO{" +
                "name='" + name + '\'' +
                "(flavor='" + flavor + '\'' +
                "), price=" + price +
                '}';
    }
}
