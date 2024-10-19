package com.payperless.kybapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.repository.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Optional<Company> find(String companyName, Country country) {
        return companyRepository.findByNameAndCountry(companyName, country);
    }

    public List<Company> save(List<Company> enriched) {
        return companyRepository.saveAll(enriched);
    }

    public Company createOrUpdate(Company newCompany) {
        Optional<Company> oldCompany = companyRepository.findById(newCompany.getId());
        if (oldCompany.isEmpty()) {
            newCompany.setId(null);
            return companyRepository.save(newCompany);
        }
        Company company = oldCompany.get();
        company.setRegistrationNumber(newCompany.getRegistrationNumber());
        company.setRegistrationLocation(newCompany.getRegistrationLocation());
        company.setEntityType(newCompany.getEntityType());
        company.setRegistrationDate(newCompany.getRegistrationDate());
        company.setCity(newCompany.getCity());
        company.setState(newCompany.getState());
        company.setZip(newCompany.getZip());
        return companyRepository.save(company);
    }

    public Company find(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(EntityNotFoundException::new);
    }
}
