package com.scurtis.stockify.model.vantage;

import java.util.List;
import lombok.Data;

@Data
public class TimeSeries {

    private List<Quote> quotes;

}
