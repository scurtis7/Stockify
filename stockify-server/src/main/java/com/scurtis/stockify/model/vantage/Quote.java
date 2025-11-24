package com.scurtis.stockify.model.vantage;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Quote {

    private String symbol;
    private LocalDate date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private Long volume;

}
