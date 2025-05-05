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
public class Cat extends Pet {

    public Cat(String name, String description, LocalDate birthDate) {
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
        this.type = Type.CAT;
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(getAgeInYears());
    }
}