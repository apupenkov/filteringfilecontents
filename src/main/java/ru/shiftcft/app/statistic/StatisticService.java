package ru.shiftcft.app.statistic;

import ru.shiftcft.data.Basket;

import java.util.Comparator;
import java.util.Objects;

public class StatisticService {

    private final Basket basket;

    public StatisticService(Basket basket) {
        this.basket = basket;
    }

    int getIntSize() {
        return basket.getInts().size();
    }

    int getFloatSize() {
        return basket.getFloats().size();
    }

    int getStringSize() {
        return basket.getStrings().size();
    }

    int getMaxIntValue() {
        return basket.getInts().stream().map(a -> Integer.parseInt(a.replace("\n", "")))
                .max(Comparator.comparingInt(a -> a)).orElse(0);
    }

    int getMinIntValue() {
        return basket.getInts().stream().map(a -> Integer.parseInt(a.replace("\n", "")))
                .min(Comparator.comparingInt(a -> a)).orElse(0);
    }

    int getAverageIntValue() {
        return getSumIntValue() / basket.getInts().size();
    }

    int getSumIntValue() {
        return basket.getInts().stream().map(a -> Integer.parseInt(a.replace("\n", ""))).reduce(0, Integer::sum);
    }

    String getMinString() {
        return basket.getStrings().stream().min(Comparator.comparingInt(String::length))
                .orElse("").replace("\n", "");
    }

    String getMaxString() {
        return basket.getStrings().stream().max(Comparator.comparingInt(String::length))
                .orElse("").replace("\n", "");
    }
}
