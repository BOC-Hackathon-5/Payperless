package com.payperless.kybapi.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {

    private String id;
    private String result;

    public DocumentResponse(String result) {
        this.id = UUID.randomUUID().toString();
        this.result = result;
    }

}
