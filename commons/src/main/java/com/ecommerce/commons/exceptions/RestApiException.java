package com.ecommerce.commons.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestApiException extends RuntimeException {
    private String message;

    public RestApiException(String message) {
        super(message);
        this.message = message;
    }
}
