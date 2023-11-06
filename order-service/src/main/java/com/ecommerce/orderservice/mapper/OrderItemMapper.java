package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemMapper {

    private final OrderItemService orderItemService;

    public void deleteOrderItem(Long id) {
        orderItemService.deleteOrderItem(id);
    }

}
