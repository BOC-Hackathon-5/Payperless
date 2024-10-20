package com.payperless.kybapi.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CompanyAge {

    private Long ageDays;

    public static CompanyAge of(LocalDate registrationDate) {
        CompanyAge companyAge = new CompanyAge();
        Long ageDays = Duration.between(
                LocalDateTime.of(registrationDate, LocalTime.MIN),
                LocalDateTime.now()
        ).toDays();
        companyAge.setAgeDays(ageDays);
        return companyAge;
    }

}
