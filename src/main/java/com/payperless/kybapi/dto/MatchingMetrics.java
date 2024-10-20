package com.payperless.kybapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMetrics {

    private Double ccoeff;
    private Double ccoeffNormed;
    private Double ccorr;
    private Double ccorrNormed;
    private Double sqdiff;
    private Double sqdiffNormed;
}
