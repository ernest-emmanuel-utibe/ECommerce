package com.ecommerce.customerservice.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import com.ecommerce.commons.dto.cart.CartRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.ecommerce.commons.constants.FeignConstants.CART_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_CART;

@FeignClient(name = CART_SERVICE, configuration = FeignClientConfiguration.class)
public interface CartClient {
    @PostMapping(value=API_V1_CART)
    ResponseEntity<Object> createCart(@Valid @RequestBody CartRequest cartRequest);
}
