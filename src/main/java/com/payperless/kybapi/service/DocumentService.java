package com.payperless.kybapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payperless.kybapi.domain.Company;
import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.enums.DocumentType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final TemplateMatchingService matchingService;
    private final OCRService ocrService;

    public List<DocumentType> getDocumentTypes() {
        return List.of(DocumentType.values());
    }

    public DocumentResponse verifyDocument(MultipartFile document, DocumentType documentType, Company company) {
        return new DocumentResponse(ocrService.processImage(document));
    }
}
