package com.ecommerce.customerservice.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import com.ecommerce.commons.dto.authentication.AuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.ecommerce.commons.constants.FeignConstants.AUTH_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_AUTH;

@FeignClient(value = AUTH_SERVICE, configuration = FeignClientConfiguration.class)
public interface AuthClient {

        @PostMapping(API_V1_AUTH)
        void authenticate(AuthenticationRequest authenticationRequest);
}
