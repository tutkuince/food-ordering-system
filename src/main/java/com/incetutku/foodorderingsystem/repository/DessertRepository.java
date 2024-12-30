package com.incetutku.foodorderingsystem.repository;

import com.incetutku.foodorderingsystem.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DessertRepository extends JpaRepository<Dessert, Long> {
    List<Dessert> findDessertsByCuisineId(Long cuisineId);
}
