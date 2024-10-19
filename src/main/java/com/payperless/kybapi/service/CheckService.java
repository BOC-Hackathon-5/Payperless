package com.payperless.kybapi.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.domain.BlackList;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.domain.client.JiniusClient;
import com.payperless.kybapi.dto.AccessToken;
import com.payperless.kybapi.dto.Check;
import com.payperless.kybapi.dto.CompanyAge;
import com.payperless.kybapi.dto.JiniusEntityResponse;
import com.payperless.kybapi.repository.BlackListRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckService {

    private static final long MINIMAL_COMPANY_AGE_DAYS = 90;
    private static final String GRANT_TYPE = "client_credentials";
    private static final String CLIENT_ID = "6054063e-d5c5-4fe7-b68a-720502d5255e";
    private static final String CLIENT_SECRET = "8n1NWgo3PuDw4vCsGkbleJ8YYNEXcP6v";
    private final BlackListRepository blackListRepository;
    private final JiniusClient jiniusClient;

    public Check<CompanyAge> companyAgeCheck(LocalDate registrationDate) {
        CompanyAge companyAge = CompanyAge.of(registrationDate);
        return new Check<>(
                companyAge.getAgeDays() >= MINIMAL_COMPANY_AGE_DAYS,
                companyAge);
    }

    public Check<BlackList> blackListCheck(Country country, String registrationNumber) {
        Optional<BlackList> blackListRecord = blackListRepository.findByCountryAndRegistrationNumber(
                country.getName(),
                registrationNumber);

        return new Check<>(
                blackListRecord.isEmpty(),
                blackListRecord.orElse(null));
    }

    public Check<JiniusEntityResponse> jiniusEntityCheck(Long companyId,
                                                         String vatNumber,
                                                         String registrationNumber,
                                                         String taxId) {
        AccessToken auth = jiniusClient.auth(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET);
        String token = "Bearer " + auth.getAccessToken();
//        String auth = jiniusClient.auth(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET);
        System.out.println("auth = " + auth);
//        String token = "Bearer ";
//        jiniusClient.findEntity(vatNumber, registrationNumber, taxId);
        JiniusEntityResponse entity = null;
        log.info("token: {}", token);
        try {
            entity = jiniusClient.findEntity(vatNumber, registrationNumber, taxId, token);
        } catch (Exception e) {
            log.error("jinius error", e);
            return new Check<>(false, null);
        }

        return new Check<>(true, entity);
    }
}
