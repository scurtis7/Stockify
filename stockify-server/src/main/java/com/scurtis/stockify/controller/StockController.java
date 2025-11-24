package com.scurtis.stockify.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scurtis.stockify.model.vantage.Quote;
import com.scurtis.stockify.service.StockService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {

    public final StockService stockService;

    @GetMapping(path = "quote")
    public List<Quote> quote(@RequestParam String function, @RequestParam String symbol) throws JsonProcessingException {
        return stockService.getQuote(function, symbol);
    }

}
