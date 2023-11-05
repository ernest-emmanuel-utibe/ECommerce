package com.ecommerce.commons.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlreadyExistsException extends RuntimeException{
    private String message;

    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
