package ru.shiftcft.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class BasketSorter {

    public void putLineToBasket(String line, Basket basket) {
        if(line != null && basket != null) {
            if (Pattern.matches("^[+-]?\\d+$", line)) {
                basket.addInt(new BigInteger(line));
                return;
            }
            if (Pattern.matches("^[+\\-]{0,1}[0-9]+[.,][0-9]+$", line)) {
                basket.addFloat(new BigDecimal(line));
            } else {
                if (!Pattern.matches("^$", line)) {
                    basket.addString(line);
                }
            }
        }
    }
}
