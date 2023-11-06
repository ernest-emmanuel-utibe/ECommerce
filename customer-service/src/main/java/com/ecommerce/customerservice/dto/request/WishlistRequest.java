package com.ecommerce.customerservice.dto.request;

import lombok.Data;

@Data
public class WishlistRequest {
    private Long customerId;
    private Long productId;
}
