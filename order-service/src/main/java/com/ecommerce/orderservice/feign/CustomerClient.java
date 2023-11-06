package com.ecommerce.orderservice.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import com.ecommerce.orderservice.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.ecommerce.commons.constants.FeignConstants.CUSTOMER_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_CUSTOMER;


@FeignClient(value = CUSTOMER_SERVICE, configuration = FeignClientConfiguration.class)
public interface CustomerClient {
    @GetMapping(API_V1_CUSTOMER + "/{customerId}")
    ResponseEntity<CustomerResponse> getById(@PathVariable("customerId") Long id);
}
