package com.payperless.kybapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNameAndCountry(String name, Country country);
}
