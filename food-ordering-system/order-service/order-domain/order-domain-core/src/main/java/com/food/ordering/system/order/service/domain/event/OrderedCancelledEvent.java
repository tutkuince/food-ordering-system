package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.event.DomainEvent;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderedCancelledEvent extends OrderEvent {
    public OrderedCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
