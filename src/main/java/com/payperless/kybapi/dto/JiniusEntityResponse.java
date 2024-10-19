package com.payperless.kybapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JiniusEntityResponse {
    private List<LegalEntity> legalEntities;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class LegalEntity {
        private String name;
        private String taxIdNumber;
        private String vatNumber;
        private String companyRegistrationNumber;
        private List<BusinessUnit> businessUnits;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class BusinessUnit {
        private String id;
        private String name;
        private String address;
        private String city;
        private String postcode;
        private List<Identifier> identifiers;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Identifier {
        private String identifierType;
        private String id;
    }

}
