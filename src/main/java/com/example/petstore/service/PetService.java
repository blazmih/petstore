package com.example.petstore.service;

import com.example.petstore.model.Pet;
import com.example.petstore.model.User;

import java.util.List;

public interface PetService {
    void createPets();
    List<Pet> listPets();
    void buy();
    void showHistory();
}
