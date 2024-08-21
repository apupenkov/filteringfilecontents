package ru.shiftcft.data;

import java.util.regex.Pattern;

public class BasketSorter {

    public void putLineToBasket(String line, Basket basket) {
        if(line != null && basket != null) {
            if (Pattern.matches("^\\d+$", line)) {
                basket.addInt(line + "\n");
                return;
            }
            if (Pattern.matches("^[+\\-]{0,1}[0-9]+[.,][0-9]+$", line)) {
                basket.addFloat(line + "\n");
            } else {
                basket.addString(line + "\n");
            }
        }
    }
}
