package ru.shiftcft.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import ru.shiftcft.app.statistic.StatisticService;
import ru.shiftcft.data.Basket;
import ru.shiftcft.data.BasketSorter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

public class SortedUnitTestsConfig {

    Basket basket;
    BasketSorter basketSorter;

    @BeforeEach
    void init() {
        basket = new Basket();
        basketSorter = new BasketSorter();
    }

    static Stream<Arguments> stringSort() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("0", "", "1.1", " "),
                        Arrays.asList(" ")),
                Arguments.of(
                        Arrays.asList("0", "double trouble", "1.1", "s1 replace"),
                        Arrays.asList("double trouble", "s1 replace")),
                Arguments.of(
                        Arrays.asList("0", "О", "0.0", "A"),
                        Arrays.asList("О", "A"))
        );
    }
}
