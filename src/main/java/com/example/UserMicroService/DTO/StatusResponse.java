package com.example.UserMicroService.DTO;

import com.example.UserMicroService.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@NoArgsConstructor
public class StatusResponse {
    private UserEntity user;
    private ProductDTO product;
    


}
