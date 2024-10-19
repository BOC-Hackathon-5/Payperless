package com.payperless.kybapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Optional<Company> find(String companyName, Country country) {
        return companyRepository.findByNameAndCountry(companyName, country);
    }

    public Company save(Company enriched) {
        return companyRepository.save(enriched);
    }
}
