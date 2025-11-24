package com.scurtis.stockify.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static org.springframework.util.Assert.hasText;

@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "alpha-vantage")
public class AVConfig {

    private String url;
    private String apiKey;

    @PostConstruct
    public void init() {
        hasText(url, "alpha-vantage.url property must be set");
        hasText(apiKey, "alpha-vantage.api-key property must be set");
    }

}
