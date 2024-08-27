package ru.shiftcft.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedUnitTests extends SortedUnitTestsConfig{

    @DisplayName("Сортировка строк")
    @ParameterizedTest
    @MethodSource("stringSort")
    void filteringStringTest(List<String> strs, List<String> expected) {
        for (String str: strs) {
            basketSorter.putLineToBasket(str, basket);
        }
        assertEquals(expected, basket.getStrings());
    }

    @DisplayName("Сортировка целых чисел")
    @ParameterizedTest
    @MethodSource("intSort")
    void filteringIntTest(List<String> strs, List<BigInteger> expected) {
        for (String num: strs) {
            basketSorter.putLineToBasket(num, basket);
        }
        assertEquals(expected, basket.getInts());
    }

    @DisplayName("Сортировка вещественных чисел")
    @ParameterizedTest
    @MethodSource("doubleSort")
    void filteringDoubleTest(List<String> strs, List<BigDecimal> expected) {
        for (String num: strs) {
            basketSorter.putLineToBasket(num, basket);
        }
        assertEquals(expected, basket.getDoubles());
    }
}
