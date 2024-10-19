package com.payperless.kybapi.facade;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.dto.Step1Dto;
import com.payperless.kybapi.dto.Step1Response;
import com.payperless.kybapi.enums.DocumentType;
import com.payperless.kybapi.service.DocumentService;
import com.payperless.kybapi.service.StepService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KybFacade {

    private final StepService stepService;
    private final DocumentService documentService;

    public Step1Response step1(Step1Dto dto) {
        return null;
    }

    public DocumentResponse verifyDocument(MultipartFile document, DocumentType documentType) {
        return documentService.verifyDocument(document, documentType);
    }

    public List<DocumentType> getDocumentTypes() {
        return documentService.getDocumentTypes();
    }
}
