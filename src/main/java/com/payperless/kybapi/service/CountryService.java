package com.payperless.kybapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country find(String countryName) {
        Optional<Country> byName = countryRepository.findByNameAndShowOnUiTrue(countryName);
        return byName.orElseThrow(IllegalArgumentException::new);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
