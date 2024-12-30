package com.incetutku.foodorderingsystem.service;

import com.incetutku.foodorderingsystem.dto.DessertDTO;
import com.incetutku.foodorderingsystem.dto.DrinkDTO;
import com.incetutku.foodorderingsystem.dto.MainCourseDTO;
import com.incetutku.foodorderingsystem.dto.OrderDTO;
import com.incetutku.foodorderingsystem.entity.Order;
import com.incetutku.foodorderingsystem.mapper.OrderMapper;
import com.incetutku.foodorderingsystem.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public OrderDTO save(OrderDTO orderDTO) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        totalPrice = totalPrice.add(setDessertPrice(orderDTO));
        totalPrice = totalPrice.add(setDrinkPrice(orderDTO));
        totalPrice = totalPrice.add(setMainCoursePrice(orderDTO));

        Order savableOrder = OrderMapper.mapToOrder(orderDTO);
        savableOrder.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(savableOrder);

        return OrderMapper.mapToOrderDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }

    private BigDecimal setDessertPrice(OrderDTO orderDTO) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (DessertDTO dessertDTO : orderDTO.getDessertDTOs()) {
            totalPrice = totalPrice.add(setScale(BigDecimal.valueOf(dessertDTO.getPrice())));
        }
        return totalPrice;
    }

    private BigDecimal setDrinkPrice(OrderDTO orderDTO) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (DrinkDTO drinkDTO : orderDTO.getDrinkDTOs()) {
            totalPrice = totalPrice.add(setScale(BigDecimal.valueOf(drinkDTO.getPrice())));
        }
        return totalPrice;
    }

    private BigDecimal setMainCoursePrice(OrderDTO orderDTO) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (MainCourseDTO mainCourseDTO : orderDTO.getMainCourseDTOs()) {
            totalPrice = totalPrice.add(setScale(BigDecimal.valueOf(mainCourseDTO.getPrice())));
        }
        return totalPrice;
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
