package ru.shiftcft.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import ru.shiftcft.app.statistic.StatisticService;
import ru.shiftcft.data.Basket;
import ru.shiftcft.data.BasketSorter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static java.math.BigInteger.*;

class SortedUnitTestsConfig {

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
                        Arrays.asList("0", "1.1", null),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList("0", "", "1.1"),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList("0", "1.1", " "),
                        Arrays.asList(" ")),
                Arguments.of(
                        Arrays.asList("0", "double trouble", "1.1", "s1 replace"),
                        Arrays.asList("double trouble", "s1 replace")),
                Arguments.of(
                        Arrays.asList("0", "О", "0.0", "A"),
                        Arrays.asList("О", "A")),
                Arguments.of(
                        Arrays.asList("0", "今天", "1.1"),
                        Arrays.asList("今天")),
                Arguments.of(
                        Arrays.asList("0", "~`@\"'$;:%%*?<>.{}[]^-+=!", "1.1"),
                        Arrays.asList("~`@\"'$;:%%*?<>.{}[]^-+=!"))
        );
    }

    static Stream<Arguments> intSort() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(null, "", "1.1", " "),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList("0", "", "1.1", " "),
                        Arrays.asList(BigInteger.valueOf(0))),
                Arguments.of(
                        Arrays.asList("0", "double trouble", "1.1", "523452344"),
                        Arrays.asList(BigInteger.valueOf(0), BigInteger.valueOf(523452344))),
                Arguments.of(
                        Arrays.asList("-1", "О", "0.0", "-14165"),
                        Arrays.asList(BigInteger.valueOf(-1), BigInteger.valueOf(-14165)))
        );
    }

    static Stream<Arguments> doubleSort() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("0", "", "1.1", " "),
                        Arrays.asList(valueOf(1.1))),
                Arguments.of(
                        Arrays.asList("0", "", null, " "),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList("0", "double trouble", "1.1", "525555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555534123.234212"),
                        Arrays.asList(valueOf(1.1), new BigDecimal("525555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555534123.234212"))),
                Arguments.of(
                        Arrays.asList("0", "-0.1", "-12342234325432543563454654654654533245432524353255555555555555555555555555555555555555555555555555555555555555555555555555554523453423425434.23412432", "A"),
                        Arrays.asList(valueOf(-0.1), new BigDecimal("-12342234325432543563454654654654533245432524353255555555555555555555555555555555555555555555555555555555555555555555555555554523453423425434.23412432")))
        );
    }
}
