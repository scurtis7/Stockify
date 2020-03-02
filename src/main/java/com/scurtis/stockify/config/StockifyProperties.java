package com.scurtis.stockify.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.notNull;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

@Data
@ConfigurationProperties(prefix = "com.scurtis.stockify")
public class StockifyProperties {

    private String apikey;

    @PostConstruct
    public void postConstruct() {
        notNull(getApikey(), "com.scurtis.stockify.apikey property must be set and may not be null");
    }

}
