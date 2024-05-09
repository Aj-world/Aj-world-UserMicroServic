package com.example.UserMicroService.Service;

import com.example.UserMicroService.Entity.UserEntity;
import com.example.UserMicroService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
     }



    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public UserEntity getUserById(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }


}
