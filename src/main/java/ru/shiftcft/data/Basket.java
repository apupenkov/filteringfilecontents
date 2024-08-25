package ru.shiftcft.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Basket {

    private final ArrayList<String> strings = new ArrayList<>();
    private final ArrayList<BigInteger> ints = new ArrayList<>();
    private final ArrayList<BigDecimal> doubles = new ArrayList<>();

    void addString(String value) {
        strings.add(value);
    }

    void addInt(BigInteger value) {
        ints.add(value);
    }

    void addFloat(BigDecimal value) {
        doubles.add(value);
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public ArrayList<BigInteger> getInts() {
        return ints;
    }

    public ArrayList<BigDecimal> getDoubles() {
        return doubles;
    }
}
