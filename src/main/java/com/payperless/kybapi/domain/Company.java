package com.payperless.kybapi.domain;

import java.time.LocalDate;

import com.payperless.kybapi.enums.TypeOfEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Country country;

    private String name;
    private String registrationNumber;
    private String registrationLocation;
    private TypeOfEntity entityType;
    private LocalDate registrationDate;
    private String city;
    private String state;
    private String zip;
}
