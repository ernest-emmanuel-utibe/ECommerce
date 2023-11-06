package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.entity.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem);
    OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem);
    void deleteOrderItem(Long id);
}
