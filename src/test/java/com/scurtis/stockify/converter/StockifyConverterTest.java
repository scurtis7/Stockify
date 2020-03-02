package com.scurtis.stockify.converter;

import com.scurtis.stockify.model.Stock;
import com.scurtis.stockify.util.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StockifyConverterTest {

    private JsonReader jsonReader = new JsonReader();
    private StockifyConverter stockifyConverter;

    private static final String BASE_PATH = "build/resources/test/";

    private String stockSearchResults;
    private List<Stock> stockList;

    @BeforeEach
    public void setUp() {
        stockSearchResults = jsonReader.readFile(BASE_PATH + "stock-search-results.json");
    }

    @Test
    void stockResultsAreCorrectlyConverted() {
        assertNotNull(stockSearchResults);
        givenStockifyConverterConfigured();
        whenConvertStockDataCalled();
        thenResultsConvertedCorrectly();
    }

    private void givenStockifyConverterConfigured() {
        stockifyConverter = new StockifyConverter();
    }

    private void whenConvertStockDataCalled() {
        stockList = stockifyConverter.convertStockData(stockSearchResults);
    }

    private void thenResultsConvertedCorrectly() {
        assertEquals(10, stockList.size());
    }

}
