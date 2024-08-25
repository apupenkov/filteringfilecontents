package ru.shiftcft.app.statistic;

import ru.shiftcft.data.Basket;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

public class StatisticService {

    private final Basket basket;

    public StatisticService(Basket basket) {
        this.basket = basket;
    }

    public int getIntSize() {
        return basket.getInts().size();
    }

    public int getFloatSize() {
        return basket.getDoubles().size();
    }

    public int getStringSize() {
        return basket.getStrings().size();
    }

    public BigInteger getMaxIntValue() {
        return basket.getInts().stream().max(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }

    public BigInteger getMinIntValue() {
        return basket.getInts().stream()
                .min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }

    public BigInteger getAvgIntValue() {
        return getSumIntValue().divide(BigInteger.valueOf(basket.getInts().size()));
    }
    public BigInteger getSumIntValue() {
        return basket.getInts().stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    public BigDecimal getSumDoubleValue() {
        return basket.getDoubles().stream().reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
    }

    public BigDecimal getMaxDoubleValue() {
        return basket.getDoubles().stream().max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getMinDoubleValue() {
        return basket.getDoubles().stream().min(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getAvgDoubleValue() {
        return getSumDoubleValue().divide(BigDecimal.valueOf(basket.getDoubles().size()));
    }

    public String getMinString() {
        return basket.getStrings().stream().min(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public String getMaxString() {
        return basket.getStrings().stream().max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
