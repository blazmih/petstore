package com.example.petstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    User owner;
    String name;
    @Enumerated(EnumType.STRING)
    Type type;
    String description;
    LocalDate birthDate;


    public abstract BigDecimal getPrice();

    public int getAgeInYears() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
