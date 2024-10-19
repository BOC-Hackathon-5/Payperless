package com.payperless.kybapi.domain.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.payperless.kybapi.dto.AccessToken;
import com.payperless.kybapi.dto.JiniusEntityResponse;

@HttpExchange(contentType = MediaType.APPLICATION_JSON_VALUE)
public interface JiniusClient {

    @PostExchange(value = "/oauth/token", contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AccessToken auth(@RequestParam(value = "grant_type") String grantType,
                     @RequestParam(value = "client_id") String clientId,
                     @RequestParam(value = "client_secret") String clientSecret);

    @GetExchange("/v3/legalEntities")
    JiniusEntityResponse findEntity(@RequestParam(value = "VatNumber", required = false) String vatNumber,
                                    @RequestParam(value = "CompanyRegistrationNumber", required = false) String registrationNumber,
                                    @RequestParam(value = "TaxIdentificationNumber", required = false) String taxId,
                                    @RequestHeader(name = "Authorization") String authorization);

}
