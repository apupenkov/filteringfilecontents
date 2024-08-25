package ru.shiftcft.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.shiftcft.app.statistic.StatisticService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsTests extends StatisticsUnitTestsConfig {

    @DisplayName("Статистика максимального значения")
    @ParameterizedTest
    @MethodSource("max")
    void statisticsMaxTest(List<BigInteger> ints, BigInteger expectedRes) {
        StatisticService statisticService = getStatServiceByInts(ints);
        BigInteger actualMaxNum = statisticService.getMaxIntValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика минимального значения")
    @ParameterizedTest
    @MethodSource("min")
    void statisticsMinTest(List<BigInteger> ints, BigInteger expectedRes) {
        StatisticService statisticService = getStatServiceByInts(ints);
        BigInteger actualMaxNum = statisticService.getMinIntValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика среднего значения")
    @ParameterizedTest
    @MethodSource("avg")
    void statisticsAvgTest(List<BigInteger> ints, BigInteger expectedRes) {
        StatisticService statisticService = getStatServiceByInts(ints);
        BigInteger actualAvg = statisticService.getAvgIntValue();
        assertEquals(expectedRes, actualAvg);
    }

    @DisplayName("Статистика суммы значений")
    @ParameterizedTest
    @MethodSource("sum")
    void statisticsSumTest(List<BigInteger> ints, BigInteger expectedRes) {
        StatisticService statisticService = getStatServiceByInts(ints);
        BigInteger actualMaxNum = statisticService.getSumIntValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика максимальных вечественных чисел")
    @ParameterizedTest
    @MethodSource("maxDec")
    void statisticsMaxDecTest(List<BigDecimal> doubles, BigDecimal expectedRes) {
        StatisticService statisticService = getStatServiceByDecs(doubles);
        BigDecimal actualMaxNum = statisticService.getMaxDoubleValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика минимальных вечественных чисел")
    @ParameterizedTest
    @MethodSource("minDec")
    void statisticsMinDecTest(List<BigDecimal> ints, BigDecimal expectedRes) {
        StatisticService statisticService = getStatServiceByDecs(ints);
        BigDecimal actualMaxNum = statisticService.getMinDoubleValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика средних вечественных чисел")
    @ParameterizedTest
    @MethodSource("avgDec")
    void statisticsAvgDecTest(List<BigDecimal> ints, BigDecimal expectedRes) {
        StatisticService statisticService = getStatServiceByDecs(ints);
        BigDecimal actualAvg = statisticService.getAvgDoubleValue();
        assertEquals(expectedRes, actualAvg);
    }

    @DisplayName("Статистика суммы вечественных чисел")
    @ParameterizedTest
    @MethodSource("sumDec")
    void statisticsSumDecTest(List<BigDecimal> ints, BigDecimal expectedRes) {
        StatisticService statisticService = getStatServiceByDecs(ints);
        BigDecimal actualMaxNum = statisticService.getSumDoubleValue();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика максимальной длинны строки")
    @ParameterizedTest
    @MethodSource("maxLengthStr")
    void statisticsMaxLengthStrTest(List<String> ints, String expectedRes) {
        StatisticService statisticService = getStatServiceByStrings(ints);
        String actualMaxNum = statisticService.getMaxString();
        assertEquals(expectedRes, actualMaxNum);
    }

    @DisplayName("Статистика максимальной длинны строки")
    @ParameterizedTest
    @MethodSource("minLengthStr")
    void statisticsMinLengthStrTest(List<String> ints, String expectedRes) {
        StatisticService statisticService = getStatServiceByStrings(ints);
        String actualMaxNum = statisticService.getMinString();
        assertEquals(expectedRes, actualMaxNum);
    }

//    @DisplayName("")
//    @ParameterizedTest
//    @MethodSource("max")
//    void filteringDataFromFileWithThrows() {
//        Throwable err = Assertions.assertThrows(RuntimeException.class, () -> {
//
//        });
//        Assertions.assertNotNull(err.getMessage());
//    }
}
