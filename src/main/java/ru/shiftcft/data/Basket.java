package ru.shiftcft.data;

import java.util.ArrayList;

public class Basket {

    private final ArrayList<String> strings = new ArrayList<>();
    private final ArrayList<String> ints = new ArrayList<>();
    private final ArrayList<String> floats = new ArrayList<>();

    void addString(String value) {
        strings.add(value);
    }

    void addInt(String value) {
        ints.add(value);
    }

    void addFloat(String value) {
        floats.add(value);
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public ArrayList<String> getInts() {
        return ints;
    }

    public ArrayList<String> getFloats() {
        return floats;
    }
}
