package com.incetutku.foodorderingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {
    private boolean addIce;
    private boolean addLemon;

    public Drink() {
        super();
    }

    public Drink(String name, double price, boolean addIce, boolean addLemon) {
        super(name, price);
        this.addIce = addIce;
        this.addLemon = addLemon;
    }

    public Drink(Long id, String name, double price, boolean addIce, boolean addLemon) {
        super(id, name, price);
        this.addIce = addIce;
        this.addLemon = addLemon;
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
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", addIce=" + addIce +
                ", addLemon=" + addLemon +
                '}';
    }
}