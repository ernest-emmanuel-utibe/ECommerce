package com.ecommerce.commons.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
public class CartRequest {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
}
