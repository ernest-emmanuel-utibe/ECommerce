package com.ecommerce.commons.dto.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartItemResponse {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    @JsonIgnoreProperties("cartItems")
    private CartResponse cart;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
