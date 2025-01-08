package com.incetutku.foodorderingsystem.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant orderTime = Instant.now();
    private BigDecimal totalPrice;
    @OneToMany
    private Set<Dessert> desserts;
    @OneToMany
    private Set<Drink> drinks;
    @OneToMany
    private Set<MainCourse> mainCourses;

    public Order() {
    }

    public Order(Set<Dessert> desserts, Set<Drink> drinks, Set<MainCourse> mainCourses) {
        this.desserts = desserts;
        this.drinks = drinks;
        this.mainCourses = mainCourses;
    }

    public Order(Long id, Instant orderTime, BigDecimal totalPrice, Set<Dessert> desserts, Set<Drink> drinks, Set<MainCourse> mainCourses) {
        this.id = id;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.desserts = desserts;
        this.drinks = drinks;
        this.mainCourses = mainCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Instant orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(Set<Dessert> desserts) {
        this.desserts = desserts;
    }

    public Set<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.drinks = drinks;
    }

    public Set<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(Set<MainCourse> mainCourses) {
        this.mainCourses = mainCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", desserts=" + desserts +
                ", drinks=" + drinks +
                ", mainCourses=" + mainCourses +
                '}';
    }
}
