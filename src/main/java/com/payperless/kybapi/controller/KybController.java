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

import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.dto.Step1Dto;
import com.payperless.kybapi.dto.Step1Response;
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
    public Step1Response step1(@RequestBody Step1Dto dto) {
        return kybFacade.step1(dto);
    }

    @Operation(summary = "", description = "")
    @PostMapping(value = "/document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DocumentResponse verifyDocument(@RequestPart(value = "doc") MultipartFile document,
                                             @RequestParam DocumentType documentType){
        return kybFacade.verifyDocument(document, documentType);
    }


    @Operation(summary = "", description = "")
    @GetMapping(value = "/document/types", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<DocumentType> getDocumentTypes(){
        return kybFacade.getDocumentTypes();
    }

}
