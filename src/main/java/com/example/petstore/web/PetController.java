package com.example.petstore.web;

import com.example.petstore.model.Pet;
import com.example.petstore.model.User;
import com.example.petstore.service.PetService;
import com.example.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    private final UserService userService;

    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createPets() {
        petService.createPets();
        return "Pets created successfully!";
    }

    @GetMapping("/list")
    public List<Pet> listPets() {
        return petService.listPets();
    }
    @PostMapping("/buy")
    public String buyPets() {
        petService.buy();
        return "Buy process completed!";
    }
    @GetMapping("/history")
    public void history() {
        petService.showHistory();
    }
}