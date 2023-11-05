package com.ecommerce.commons.dto.authentication;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
