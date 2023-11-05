package com.ecommerce.cartservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = CATALOG_SERVICE, configuration = FeignClientConfiguration.class)
public interface ProductClient {
    @GetMapping(value=API_V1_PRODUCT + "/{productId}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Long productId);
}
