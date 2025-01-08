package com.incetutku.foodorderingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CuisineDTO {
    private long id;
    private String name;
    private String desc;
    private Set<MainCourseDTO> mainCourseDTOS = new HashSet<>();
    private Set<DessertDTO> dessertDTOS = new HashSet<>();

    public CuisineDTO() {
    }

    public CuisineDTO(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public CuisineDTO(long id, String name, String desc, Set<MainCourseDTO> mainCourseDTOS, Set<DessertDTO> dessertDTOS) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.mainCourseDTOS = mainCourseDTOS;
        this.dessertDTOS = dessertDTOS;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<MainCourseDTO> getMainCourseDTOS() {
        return mainCourseDTOS;
    }

    public void setMainCourseDTOS(Set<MainCourseDTO> mainCourseDTOS) {
        this.mainCourseDTOS = mainCourseDTOS;
    }

    public Set<DessertDTO> getDessertDTOS() {
        return dessertDTOS;
    }

    public void setDessertDTOS(Set<DessertDTO> dessertDTOS) {
        this.dessertDTOS = dessertDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuisineDTO that = (CuisineDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id + ", name='" + name + '\'' +
                ", desc='" + desc;
    }
}
