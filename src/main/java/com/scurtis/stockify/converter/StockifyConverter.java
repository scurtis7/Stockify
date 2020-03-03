package com.scurtis.stockify.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.stockify.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

@Slf4j
public class StockifyConverter {

    private ObjectMapper mapper = new ObjectMapper();

    private static final String NODE_SYMBOL = "1. symbol";
    private static final String NODE_NAME = "2. name";
    private static final String NODE_TYPE = "3. type";
    private static final String NODE_REGION = "4. region";
    private static final String NODE_MARKET_OPEN = "5. marketOpen";
    private static final String NODE_MARKET_CLOSE = "6. marketClose";
    private static final String NODE_TIMEZONE = "7. timezone";
    private static final String NODE_CURRENCY = "8. currency";
    private static final String NODE_MATCH_SCORE = "9. matchScore";

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
        if (StringUtils.isEmpty(data)) {
            return searchResults;
        }

        try {
            JsonNode rootNode = mapper.readTree(data);
            JsonNode stockNodes = rootNode.findValue("bestMatches");

            if (stockNodes.isArray()) {
                for (JsonNode arrayItem : stockNodes) {
                    searchResults.add(convertArrayItemToStock(arrayItem));
                }
            }
        } catch (JsonProcessingException exception) {
            log.error("Exception while converting stock data: ", exception);
        }

        return searchResults;

    }

    private Stock convertArrayItemToStock(JsonNode arrayItem) {
        Stock stock = new Stock();
        stock.setSymbol(arrayItem.get(NODE_SYMBOL).textValue());
        stock.setName(arrayItem.get(NODE_NAME).textValue());
        stock.setType(arrayItem.get(NODE_TYPE).textValue());
        stock.setRegion(arrayItem.get(NODE_REGION).textValue());
        stock.setTimezone(arrayItem.get(NODE_TIMEZONE).textValue());
        return stock;
    }

}
