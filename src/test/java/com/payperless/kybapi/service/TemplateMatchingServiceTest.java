package com.payperless.kybapi.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.payperless.kybapi.dto.MatchingMetrics;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMatchingServiceTest {

    private final TemplateMatchingService service = new TemplateMatchingService();

    @Test
    public void testCompareDocumentWithTemplate() {
        String documentPath = "/Users/dmitriygusev/IdeaProjects/kyb-api/src/test/resources/test.jpeg";
        String templatePath = "/Users/dmitriygusev/IdeaProjects/kyb-api/src/main/resources/templates/cert_in_template.png";

        // When
        var res = service.compareDocumentWithTemplate(documentPath, templatePath);

        // Then
        System.out.println(res);
    }

}