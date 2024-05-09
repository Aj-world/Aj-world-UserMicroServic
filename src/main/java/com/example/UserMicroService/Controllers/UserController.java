package com.example.UserMicroService.Controllers;

import com.example.UserMicroService.Client.ImageClient;
import com.example.UserMicroService.Client.ProductClient;
import com.example.UserMicroService.DTO.ProductDTO;
import com.example.UserMicroService.Entity.UserEntity;
import com.example.UserMicroService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final ProductClient productClient;
    private final ImageClient imageClient;

    @Autowired
    public UserController(UserService userService,ProductClient productClient,ImageClient imageClient) {
        this.userService = userService;
        this.productClient=productClient;
        this.imageClient=imageClient;
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<?> getStatus(@PathVariable("id") Integer id) {
        try {
            ProductDTO product = productClient.getproduct(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching product data: " + e.getMessage());
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity) {
        try {
            userService.addUser(userEntity);
            return ResponseEntity.ok("User added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding user: " + e.getMessage());
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser() {
        try {
            List<UserEntity> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/userImage/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Integer id) {
        try {
            Resource imageResource = imageClient.getImage(id);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageResource);
        } catch (Exception e) {
            System.out.println("ImageNotFoundException occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // handle the error appropriately
        }
   }
}
