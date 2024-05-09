package com.example.UserMicroService.Client;

import com.example.UserMicroService.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-MICROSERVICE")
public interface ProductClient {

    @GetMapping("/getProduct/{id}")
    ProductDTO getproduct(@PathVariable("id") int id);

}