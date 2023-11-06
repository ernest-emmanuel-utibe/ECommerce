package com.ecommerce.catalogservice.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.ecommerce.commons.constants.FeignConstants.CUSTOMER_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_CUSTOMER;

@FeignClient(name = CUSTOMER_SERVICE, configuration = FeignClientConfiguration.class)
public interface CustomerClient {
    @GetMapping(value=API_V1_CUSTOMER + "/{id}")
    ResponseEntity<Object> getById(@PathVariable("id") Long id);

}
