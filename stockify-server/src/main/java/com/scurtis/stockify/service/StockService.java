package com.scurtis.stockify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.stockify.config.AVConfig;
import com.scurtis.stockify.model.vantage.Quote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class StockService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final AVConfig avConfig;
    private final RestClient restClient;
    private final UtilityService utilityService;

    public List<Quote> getQuote(String function, String symbol) throws JsonProcessingException {
        String url = getUri(function, symbol);
        String result = restClient.get()
            .uri(url)
            .retrieve()
            .body(String.class);

        JsonNode rootNode = objectMapper.readTree(result);
        JsonNode timeSeriesNode = getTimeSeriesNode(function, rootNode);
        return getQuotes(symbol, timeSeriesNode);
    }

    private JsonNode getTimeSeriesNode(String function, JsonNode rootNode) {
        if (function.equalsIgnoreCase("Intraday")) {
            return rootNode.get("Time Series (Intraday)");
        } else if (function.equalsIgnoreCase("Daily")) {
            return rootNode.get("Time Series (Daily)");
        } else if (function.equalsIgnoreCase("Weekly")) {
            return rootNode.get("Time Series (Weekly)");
        } else if (function.equalsIgnoreCase("Monthly")) {
            return rootNode.get("Time Series (Monthly)");
        }
        return null;
    }

    private List<Quote> getQuotes(String symbol, JsonNode timeSeriesNode) {
        List<Quote> quotes = new ArrayList<>();
        if (timeSeriesNode != null) {
            Iterator<String> dateFieldNames = timeSeriesNode.fieldNames();
            while (dateFieldNames.hasNext()) {
                String date = dateFieldNames.next();
                LocalDate quoteDate = LocalDate.parse(date);
                Quote quote = new Quote();
                quote.setSymbol(symbol);
                quote.setDate(quoteDate);
                JsonNode quoteNode = timeSeriesNode.get(date);
                quote.setOpen(utilityService.stringToBigDecimal(quoteNode.get("1. open")));
                quote.setHigh(utilityService.stringToBigDecimal(quoteNode.get("2. high")));
                quote.setLow(utilityService.stringToBigDecimal(quoteNode.get("3. low")));
                quote.setClose(utilityService.stringToBigDecimal(quoteNode.get("4. close")));
                quote.setVolume(utilityService.stringToLong(quoteNode.get("5. volume")));
                quotes.add(quote);
            }
        }
        return quotes;
    }

    private String getUri(String function, String symbol) {
        if (function.equalsIgnoreCase("Intraday")) {
            function = "TIME_SERIES_INTRADAY";
        } else if (function.equalsIgnoreCase("Daily")) {
            function = "TIME_SERIES_DAILY";
        } else if (function.equalsIgnoreCase("Weekly")) {
            function = "TIME_SERIES_WEEKLY";
        } else if (function.equalsIgnoreCase("Monthly")) {
            function = "TIME_SERIES_MONTHLY";
        }
        return String.format("%s/query?apikey=%s&function=%s&symbol=%s", avConfig.getUrl(), avConfig.getApiKey(), function, symbol);
    }

}
