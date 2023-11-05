package com.ecommerce.commons.feign;

import com.ecommerce.commons.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static com.ecommerce.commons.constants.FeignConstants.IMAGE_SERVICE;
import static com.ecommerce.commons.constants.PathConstants.API_V1_IMAGE;

@FeignClient(name = IMAGE_SERVICE, configuration = FeignClientConfiguration.class)
public class ImageClient {
    @PostMapping(value=API_V1_IMAGE + "/upload",consumes = {"multipart/form-data"})
    String uploadImage(@RequestPart("file") MultipartFile file);

}
