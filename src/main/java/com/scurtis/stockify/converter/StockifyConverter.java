package com.scurtis.stockify.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.stockify.model.Stock;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

@Slf4j
public class StockifyConverter {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * "1. symbol": "XIACF",
     * "2. name": "Xiaomi Corporation",
     * "3. type": "Equity",
     * "4. region": "United States",
     * "5. marketOpen": "09:30",
     * "6. marketClose": "16:00",
     * "7. timezone": "UTC-05",
     * "8. currency": "USD",
     * "9. matchScore": "0.5455"
     */
    public List<Stock> convertStockData(String data) {
        log.info("Method: convertStockData()");
        List<Stock> searchResults = new ArrayList<>();

        try {
            JsonNode rootNode = mapper.readTree(data);
            JsonNode stockNodes = rootNode.findValue("bestMatches");

            log.info(rootNode.asText(), stockNodes.asText());
        } catch (JsonProcessingException exception) {
            log.error("Exception while converting stock data: ", exception);
        }

        return searchResults;

    }

}
