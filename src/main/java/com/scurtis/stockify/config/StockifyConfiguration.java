package com.scurtis.stockify.config;

import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.webservice.AlphaVantageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

@Configuration
public class StockifyConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public StockifyProperties stockifyProperties() {
        return new StockifyProperties();
    }

    @Bean
    public AlphaVantageService alphaVantageService(RestTemplate restTemplate, StockifyConverter converter) {
        return new AlphaVantageService(restTemplate, converter);
    }

    @Bean
    public StockifyConverter stockifyConverter() {
        return new StockifyConverter();
    }

}
