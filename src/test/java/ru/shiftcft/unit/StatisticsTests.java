package ru.shiftcft.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.shiftcft.app.statistic.StatisticService;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTests extends StatisticsUnitTestsConfig{

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

    @DisplayName("")
    @ParameterizedTest
    @MethodSource("max")
    void filteringDataFromFileWithThrows() {
        Throwable err = Assertions.assertThrows(RuntimeException.class, () -> {

        });
        Assertions.assertNotNull(err.getMessage());
    }
}
