package com.example.UserMicroService.Repository;

import com.example.UserMicroService.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
