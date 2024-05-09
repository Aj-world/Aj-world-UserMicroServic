package com.example.UserMicroService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IMAGE-MICROSERVICE", path="/api/images")
public interface ImageClient {

    @GetMapping("/download/{id}")
    Resource getImage(@PathVariable("id") int id);

}
