package com.incetutku.foodorderingsystem.repository;

import com.incetutku.foodorderingsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
