package com.ecommerce.commons.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductQuantityUnavailableException extends RuntimeException{
    private String message;

    public ProductQuantityUnavailableException(String message) {
        super(message);
        this.message = message;
    }
}
