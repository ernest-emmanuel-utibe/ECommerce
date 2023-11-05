package com.ecommerce.cartservice.feign;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = ORDER_SERVICE, configuration = FeignClientConfiguration)
public interface OrderClient {
        @PostMapping(value=API_V1_ORDER)
        ResponseEntity<Object> create(@Valid @RequestBody CartResponse cart);
}
