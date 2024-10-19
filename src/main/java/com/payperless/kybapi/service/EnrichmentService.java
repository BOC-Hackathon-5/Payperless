package com.payperless.kybapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.enums.TypeOfEntity;

@Service
public class EnrichmentService {

    public Company enrich(String companyName, Country country) {
        return mockCompany(companyName, country);
    }

    private Company mockCompany(String companyName, Country country) {
        return Company.builder()
                .name(companyName)
                .country(country)
                .registrationNumber("CY1002000765")
                .registrationLocation("Limassol")
                .entityType(TypeOfEntity.CORPORATION)
                .registrationDate(LocalDate.of(2000, 7, 15))
                .city("Limassol")
                .state("Limassol")
                .zip("3203")
                .build();
    }
}
