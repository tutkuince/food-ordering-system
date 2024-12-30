package com.incetutku.foodorderingsystem.repository;

import com.incetutku.foodorderingsystem.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
}
