package com.example.petstore.service;

import com.example.petstore.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    List<User> createUsers();
    List<User> listUsers();
    boolean canAffordPet(User user, BigDecimal petPrice);

    User findUserById(Long userId);
}
