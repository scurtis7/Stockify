package com.scurtis.stockify.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "scurtis")
public class AppConfig {

    private String appVersion;

    @PostConstruct
    public void init() {
        log.info("App Version: {}", appVersion);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }

}
