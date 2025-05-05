package com.example.petstore.service.impl;

import com.example.petstore.model.User;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> createUsers() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName("FirstName" + (i + 1));
            user.setLastName("LastName" + (i + 1));
            user.setEmail("email" + (i + 1) + "@gmail.com");
            user.setBudget(BigDecimal.valueOf(10 + random.nextInt(90)));
            userRepository.save(user);
        }
        return userRepository.findAll();
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean canAffordPet(User user, BigDecimal petPrice) {
        return user.getBudget().compareTo(petPrice) >= 0;
    }
}