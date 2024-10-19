package com.payperless.kybapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payperless.kybapi.domain.BlackList;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    Optional<BlackList> findByCountryAndRegistrationNumber(String country, String registrationNumber);
}
