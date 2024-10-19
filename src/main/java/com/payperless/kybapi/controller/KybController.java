package com.payperless.kybapi.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.domain.Country;
import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.dto.Step1Dto;
import com.payperless.kybapi.enums.DocumentType;
import com.payperless.kybapi.facade.KybFacade;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/kyb")
@RequiredArgsConstructor
class KybController {

    private final KybFacade kybFacade;

    @SuppressWarnings("SameReturnValue")
    @Operation(summary = "Return pong if currency valid and enabled")
    @GetMapping(value = "/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping(value = "/step/1")
    @Operation(summary = "")
    public List<Company> step1(@RequestBody Step1Dto dto) {
        return kybFacade.step1(dto);
    }

    @PostMapping(value = "/step/2")
    @Operation(summary = "")
    public Company step2(@RequestBody Company dto) {
        return kybFacade.createOrUpdate(dto);
    }

    @Operation(summary = "", description = "")
    @PostMapping(value = "/document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DocumentResponse verifyDocument(@RequestPart(value = "doc") MultipartFile document,
                                           @RequestParam DocumentType documentType) {
        return kybFacade.verifyDocument(document, documentType);
    }

    @Operation(summary = "", description = "")
    @GetMapping(value = "/document/types")
    public List<DocumentType> getDocumentTypes() {
        return kybFacade.getDocumentTypes();
    }

    @Operation(summary = "", description = "")
    @GetMapping(value = "/country/list")
    public List<Country> getCountries() {
        return kybFacade.getCountries();
    }

}
