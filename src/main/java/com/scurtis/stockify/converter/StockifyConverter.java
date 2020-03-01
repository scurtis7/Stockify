package com.scurtis.stockify.converter;

import com.scurtis.stockify.model.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 01, 2020
 **/

public class StockifyConverter {

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
        return new ArrayList<>();
    }

}
