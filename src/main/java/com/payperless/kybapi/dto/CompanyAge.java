package com.payperless.kybapi.dto;

import java.time.Duration;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CompanyAge {

    private Long ageDays;

    public static CompanyAge of(LocalDate registrationDate) {
        CompanyAge companyAge = new CompanyAge();
        Long ageDays = Duration.between(registrationDate, LocalDate.now()).toDays();
        companyAge.setAgeDays(ageDays);
        return companyAge;
    }

}
