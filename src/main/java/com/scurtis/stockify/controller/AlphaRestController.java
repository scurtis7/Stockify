package com.scurtis.stockify.controller;

import com.scurtis.stockify.model.Stock;
import com.scurtis.stockify.webservice.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 02, 2020
 **/

@RestController
@RequestMapping("/alpha")
@RequiredArgsConstructor
public class AlphaRestController {

    private final AlphaVantageService alphaVantageService;

    @RequestMapping(value = "/search/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Stock> search(@PathVariable("symbol") String symbol) {
        return alphaVantageService.search(symbol);
    }

}
