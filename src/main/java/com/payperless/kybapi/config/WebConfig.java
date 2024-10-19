package com.payperless.kybapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.payperless.kybapi.domain.client.JiniusClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebConfig {

    @Bean
    public JiniusClient jiniusClient() {
        String url = "https://api.integration.platform.cy";

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build();
        return httpServiceProxyFactory.createClient(JiniusClient.class);
    }

}
