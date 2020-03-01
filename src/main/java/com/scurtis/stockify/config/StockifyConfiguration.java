package com.scurtis.stockify.config;

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
    public AlphaVantageService alphaVantageService(RestTemplate restTemplate) {
        return new AlphaVantageService(restTemplate);
    }

}
