package com.example.petstore;

import com.example.petstore.model.Dog;
import com.example.petstore.model.Pet;
import com.example.petstore.model.User;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetstoreApplicationTests {

	@Autowired
	private PetService petService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PetRepository petRepository;

	private User testUser;
	private Pet testPet;

	@BeforeEach
	public void setUp() {
		testUser = new User("John", "Doe", "john@gmail.com", new BigDecimal("100"));
		userRepository.save(testUser);
		testPet = new Dog("Fido", "Cute", LocalDate.of(2022, 5, 10), 7);
		petRepository.save(testPet);
	}

	@Test
	public void testBuyPetNotEnoughBudget() {
		testUser.setBudget(new BigDecimal("30"));
		userRepository.save(testUser);
		petService.buy();
		assertNull(testPet.getOwner());
		assertEquals(new BigDecimal("30"), testUser.getBudget());
	}

	@Test
	public void testBuyPetAlreadyOwned() {
		User anotherUser = new User("Jana", "J", "jana@gmail.com", new BigDecimal("100"));
		userRepository.save(anotherUser);
		testPet.setOwner(anotherUser);
		petRepository.save(testPet);
		petService.buy();
		assertEquals(anotherUser, testPet.getOwner());
	}
}
