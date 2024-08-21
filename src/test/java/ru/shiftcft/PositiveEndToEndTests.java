package ru.shiftcft;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.shiftcft.app.ContentsFilter;
import ru.shiftcft.utils.ConsoleCommand;
import ru.shiftcft.utils.ConsoleCommand.Builder;

import static ru.shiftcft.utils.ConsoleCommand.StatisticType.SIMPLE;

class PositiveEndToEndTests {

    @DisplayName("Фильтрация корректных данных из файла")
    @Test
    void filteringCorrectDataFromFile() {
        ConsoleCommand consoleCommand = new Builder()
                .addData(true)
                .statistic(SIMPLE)
                .resultPath("/some/path")
                .prefix("result_")
                .build();
        ContentsFilter contentsFilter = new ContentsFilter(consoleCommand);
        contentsFilter.execute();
    }
}
