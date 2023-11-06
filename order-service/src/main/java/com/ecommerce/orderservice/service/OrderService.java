package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Order create(Order order);
    Page<Order> getAll(Pageable pageable);
    Order getOrderById(Long id);
    Page<OrderItem> getOrderItemsByOrder(Long orderId, Pageable pageable);
    Page<Order> getOrdersByCustomer(Long customerId, Pageable pageable);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long id);
}
