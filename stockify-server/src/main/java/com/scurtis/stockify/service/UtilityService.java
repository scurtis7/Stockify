package com.scurtis.stockify.service;

import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

    public BigDecimal stringToBigDecimal(JsonNode node) {
        String input = node.asText();
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)");
        if (StringUtils.isNotBlank(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return new BigDecimal(input);
            }
        }
        return new BigDecimal("0.0");
    }

    public Long stringToLong(JsonNode node) {
        String input = node.asText();
        Pattern pattern = Pattern.compile("\\d+");
        if (StringUtils.isNotBlank(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return Long.parseLong(input);
            }
        }
        return 0L;
    }

}
