package com.payperless.kybapi.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JiniusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Company company;
    private String name;
    private String taxIdNumber;
    private String vatNumber;
    private String companyRegistrationNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jiniusEntity")
    private List<BusinessUnit> businessUnits;

}
