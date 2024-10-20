package com.payperless.kybapi.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.payperless.kybapi.domain.BlackList;
import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.dto.Check;
import com.payperless.kybapi.dto.CompanyAge;
import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.dto.JiniusEntityResponse;
import com.payperless.kybapi.dto.KybResult;
import com.payperless.kybapi.dto.Step1Dto;
import com.payperless.kybapi.enums.DocumentType;
import com.payperless.kybapi.service.CheckService;
import com.payperless.kybapi.service.CompanyService;
import com.payperless.kybapi.service.CountryService;
import com.payperless.kybapi.service.DocumentService;
import com.payperless.kybapi.service.EnrichmentService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KybFacade {

    private final CheckService checkService;
    private final DocumentService documentService;
    private final EnrichmentService enrichmentService;
    private final CompanyService companyService;
    private final CountryService countryService;

    public List<Company> step1(Step1Dto dto) {
        Country country = countryService.find(dto.getCountry());
        Optional<Company> company = companyService.find(dto.getCompanyName(), country);
        if (company.isPresent()) {
            return List.of(company.get());
        }

        List<Company> enriched = enrichmentService.enrich(dto.getCompanyName(), country);
        return companyService.save(enriched);
    }

    public DocumentResponse verifyDocument(MultipartFile document, DocumentType documentType) {
        return documentService.verifyDocument(document, documentType);
    }

    public List<DocumentType> getDocumentTypes() {
        return documentService.getDocumentTypes();
    }

    public List<Country> getCountries() {
        return countryService.getAll();
    }

    public Company createOrUpdate(Company newCompany) {
        return companyService.createOrUpdate(newCompany);
    }

    public KybResult getResult(Long companyId) {
        Company company = companyService.find(companyId);
        Check<CompanyAge> companyAgeCheck = checkService.companyAgeCheck(company.getRegistrationDate());
        Check<BlackList> blackListCheck = checkService.blackListCheck(company.getCountry(), company.getRegistrationNumber());
//        Check<JiniusEntityResponse> jiniusEntityCheck = checkService.jiniusEntityCheck(
//                company.getId(),
//                company.getVatNumber(),
//                company.getRegistrationNumber(),
//                company.getTaxId());

        Check<JiniusEntityResponse> jiniusEntityCheck = checkService.jiniusEntityCheck(
                company.getId(),
                "12345680X",
                "HE435670",
                "77779999X");
        return new KybResult(
                company,
                List.of(),
                jiniusEntityCheck,
                blackListCheck,
                companyAgeCheck
        );
    }
}
