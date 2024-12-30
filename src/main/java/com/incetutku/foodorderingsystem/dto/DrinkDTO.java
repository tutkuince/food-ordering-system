package com.incetutku.foodorderingsystem.dto;

import java.util.Objects;

public class DrinkDTO {
    private Long id;
    private String name;
    private double price;
    private boolean addIce;
    private boolean addLemon;

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

    public boolean isAddIce() {
        return addIce;
    }

    public void setAddIce(boolean addIce) {
        this.addIce = addIce;
    }

    public boolean isAddLemon() {
        return addLemon;
    }

    public void setAddLemon(boolean addLemon) {
        this.addLemon = addLemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkDTO drinkDTO = (DrinkDTO) o;
        return Objects.equals(id, drinkDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", addIce=" + addIce +
                ", addLemon=" + addLemon +
                '}';
    }
}
