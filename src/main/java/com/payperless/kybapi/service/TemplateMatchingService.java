package com.payperless.kybapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.payperless.kybapi.dto.MatchingMetrics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TemplateMatchingService {

    public MatchingMetrics compareDocumentWithTemplate(String documentPath, String templatePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python3", "src/main/resources/match_template.py", documentPath, templatePath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();
            var metrics = Arrays.stream(output.toString().split("\n")).map(Double::parseDouble).toList();
            return new MatchingMetrics(metrics.get(0), metrics.get(1), metrics.get(2),
                    metrics.get(3), metrics.get(4), metrics.get(5)
            );
        }  catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
