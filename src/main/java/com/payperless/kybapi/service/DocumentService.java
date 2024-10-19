package com.payperless.kybapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payperless.kybapi.dto.DocumentResponse;
import com.payperless.kybapi.enums.DocumentType;

@Service
public class DocumentService {
    public List<DocumentType> getDocumentTypes() {
        return List.of(DocumentType.values());
    }

    public DocumentResponse verifyDocument(MultipartFile document, DocumentType documentType) {
        return null;
    }
}
