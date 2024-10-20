package com.payperless.kybapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.enums.TypeOfEntity;

@Service
public class EnrichmentService {

    public List<Company> enrich(String companyName, Country country) {
        return List.of(mockCompany(companyName, country));
    }

    private Company mockCompany(String companyName, Country country) {
        return Company.builder()
                .name(companyName)
                .country(country)
                .registrationNumber("HE435670")
                .vatNumber("12345680X")
                .taxId("77779999X")
                .registrationLocation("Limassol")
                .entityType(TypeOfEntity.CORPORATION)
                .registrationDate(LocalDate.of(2000, 7, 15))
                .city("Limassol")
                .state("Limassol")
                .zip("3203")
                .build();
    }
}
