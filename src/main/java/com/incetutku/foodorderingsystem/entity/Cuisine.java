package com.incetutku.foodorderingsystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String desc;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MainCourse> mainCourses;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dessert> desserts;

    public Cuisine() {
    }

    public Cuisine(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Cuisine(String name, String desc, Set<MainCourse> mainCourses, Set<Dessert> desserts) {
        this.name = name;
        this.desc = desc;
        this.mainCourses = mainCourses;
        this.desserts = desserts;
    }

    public Cuisine(Long id, String name, String desc, Set<MainCourse> mainCourses, Set<Dessert> desserts) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.mainCourses = mainCourses;
        this.desserts = desserts;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(Set<MainCourse> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public Set<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(Set<Dessert> desserts) {
        this.desserts = desserts;
    }
}
