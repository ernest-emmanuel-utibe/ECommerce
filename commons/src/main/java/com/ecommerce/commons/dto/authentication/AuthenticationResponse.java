package com.ecommerce.commons.dto.authentication;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwtToken;
}
