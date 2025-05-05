package com.example.petstore.service.impl;

import com.example.petstore.model.*;
import com.example.petstore.repository.HistoryLogRepository;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.PetService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;
    private final HistoryLogRepository historyLogRepository;

    public PetServiceImpl(PetRepository petRepository, UserRepository userRepository, HistoryLogRepository historyLogRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
        this.historyLogRepository = historyLogRepository;
    }

    @Override
    public void createPets() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Dog dog = new Dog("Dog" + (i + 1), "Dog Description " + (i + 1),
                    LocalDate.of(2025, 1 + random.nextInt(12),
                            1 + random.nextInt(28)),
                    1 + random.nextInt(10));
            petRepository.save(dog);
        }

        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat("Cat" + (i + 1), "Cat Description " + (i + 1),
                    LocalDate.of(2024, 1 + random.nextInt(12),
                            1 + random.nextInt(28)));
            petRepository.save(cat);
        }
    }

    @Override
    public List<Pet> listPets() {
        return petRepository.findAll();
    }

    @Override
    public void buy() {
        int successCount = 0;
        int failureCount = 0;

        List<User> users = userRepository.findAll();

        for (User user : users) {
            List<Pet> availablePets = new ArrayList<>();
            for (Pet pet : petRepository.findAll()) {
                if (pet.getOwner() == null) {
                    availablePets.add(pet);
                }
            }
            for (Pet pet : availablePets) {
                if (user.getBudget().compareTo(pet.getPrice()) >= 0) {
                    user.setBudget(user.getBudget().subtract(pet.getPrice()));
                    pet.setOwner(user);
                    petRepository.save(pet);
                    successCount++;
                    break;
                }
                else {
                    failureCount++;
                }
            }
        }
        HistoryLog historyLog = new HistoryLog(LocalDateTime.now(), successCount, failureCount);
        historyLogRepository.save(historyLog);
    }
    @Override
    public void showHistory() {
        historyLogRepository.findAll().forEach(h -> {
            System.out.printf("Date: %s | Success: %d | Failed: %d%n",
                    h.getDate(), h.getSuccessCount(), h.getFailureCount());
        });
    }
}