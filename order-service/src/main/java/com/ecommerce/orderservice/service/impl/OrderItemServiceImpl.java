package com.ecommerce.orderservice.service.impl;

import com.ecommerce.orderservice.entity.OrderItem;
import com.ecommerce.orderservice.feign.ProductClient;
import com.ecommerce.orderservice.repository.OrderItemRepository;
import com.ecommerce.orderservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductClient productClient;

    private void increaseOrderCount(Long productId) {
        productClient.updateOrdersCount(productId, true);
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        increaseOrderCount(orderItem.getProductId());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow();
        orderItem.setQuantity(updatedOrderItem.getQuantity());
        orderItem.setOrder(updatedOrderItem.getOrder());
        orderItem.setProductId(updatedOrderItem.getProductId());
        if(!Objects.equals(orderItem.getProductId(), updatedOrderItem.getProductId())) {
            increaseOrderCount(updatedOrderItem.getProductId());
        }
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
