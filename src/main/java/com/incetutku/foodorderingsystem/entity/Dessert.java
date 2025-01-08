package com.incetutku.foodorderingsystem.entity;

import jakarta.persistence.Entity;

@Entity
public class Dessert extends MenuItem {
    private String flavor;
    private Long cuisineId;

    public Dessert() {
        super();
    }

    public Dessert(String name, double price, String flavor, Long cuisineId) {
        super(name, price);
        this.flavor = flavor;
        this.cuisineId = cuisineId;
    }

    public Dessert(Long id, String name, double price, String flavor, Long cuisineId) {
        super(id, name, price);
        this.flavor = flavor;
        this.cuisineId = cuisineId;
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
    public String toString() {
        return "Dessert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", flavor='" + flavor + '\'' +
                ", cuisineId=" + cuisineId +
                '}';
    }
}
