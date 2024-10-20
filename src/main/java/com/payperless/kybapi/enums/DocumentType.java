package com.payperless.kybapi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentType {

    INCORPORATION_CERTIFICATE("src/main/resources/templates/cert_in_template.png"),
    SHAREHOLDER_REGISTRY(""),
    PROOF_OF_ADDRESS("");

    private final String path;

}
