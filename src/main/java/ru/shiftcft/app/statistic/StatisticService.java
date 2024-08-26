package ru.shiftcft.app.statistic;

import ru.shiftcft.data.Basket;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

import static java.math.BigInteger.ZERO;

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
        return basket.getInts().stream().max(BigInteger::compareTo).orElse(ZERO);
    }

    public BigInteger getMinIntValue() {
        return basket.getInts().stream()
                .min(BigInteger::compareTo).orElse(ZERO);
    }

    public BigInteger getAvgIntValue() {
        int size = basket.getInts().size();
        return size == 0 ? ZERO : getSumIntValue().divide(BigInteger.valueOf(size));
    }
    public BigInteger getSumIntValue() {
        return basket.getInts().stream().reduce(ZERO, BigInteger::add);
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
        int size = basket.getDoubles().size();
        return size == 0 ? BigDecimal.ZERO : getSumDoubleValue().divide(BigDecimal.valueOf(size));
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
