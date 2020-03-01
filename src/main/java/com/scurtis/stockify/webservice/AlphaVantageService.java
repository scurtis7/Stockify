package com.scurtis.stockify.webservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

@RequiredArgsConstructor
@Slf4j
public class AlphaVantageService {

    private final RestTemplate restTemplate;

    public ResponseEntity<String> callWebservice(String url) {
        log.info("Method: callWebservice({})", url);
        return restTemplate.getForEntity(url, String.class);
    }


}
