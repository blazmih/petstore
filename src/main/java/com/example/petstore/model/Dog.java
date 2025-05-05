package com.example.petstore.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Pet {

    private int rating;

    public Dog(String name, String description, LocalDate birthDate, int rating) {
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
        this.rating = rating;
        this.type = Type.DOG;
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(getAgeInYears() + rating);
    }
}