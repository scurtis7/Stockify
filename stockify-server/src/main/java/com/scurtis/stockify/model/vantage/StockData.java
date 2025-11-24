package com.scurtis.stockify.model.vantage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockData {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    private TimeSeries timeSeries;

}
