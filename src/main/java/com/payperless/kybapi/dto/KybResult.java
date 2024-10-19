package com.payperless.kybapi.dto;

import java.util.List;

import com.payperless.kybapi.domain.BlackList;
import com.payperless.kybapi.domain.Company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KybResult {

    private Company company;
    private List<Long> documentIds;
    private Check<JiniusEntityResponse> jiniusEntity;
    private Check<BlackList> blackListCheck;
    private Check<CompanyAge> companyAgeCheck;
}
