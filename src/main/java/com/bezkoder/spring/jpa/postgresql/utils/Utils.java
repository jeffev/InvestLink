package com.bezkoder.spring.jpa.postgresql.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class Utils {
    public static BigDecimal stringToBiGDecimal (String texto) throws ParseException {
        if ((texto == null ) || (texto.trim().isEmpty())) { return new BigDecimal(0); }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        decimalFormat.setParseBigDecimal(true);
        return (BigDecimal) decimalFormat.parse(texto);
    }
}
