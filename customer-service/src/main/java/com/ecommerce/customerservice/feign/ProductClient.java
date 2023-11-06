package com.ecommerce.customerservice.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import com.ecommerce.commons.dto.catalog.product.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.ecommerce.commons.constants.FeignConstants.CATALOG_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_PRODUCT;

@FeignClient(name = CATALOG_SERVICE, configuration = FeignClientConfiguration.class)
public interface ProductClient {
    @GetMapping(value=API_V1_PRODUCT + "/{productId}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Long productId);

}
