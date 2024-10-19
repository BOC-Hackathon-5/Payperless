package com.payperless.kybapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Check<T> {

    private Boolean result;
    private T data;

}
