package ru.shiftcft;

import ru.shiftcft.app.ContentsFilter;
import ru.shiftcft.utils.ConsoleCommand;

import static ru.shiftcft.utils.ConsoleCommand.StatisticType.SIMPLE;

public class ApplicationRunner {

    public static void main(String[] args) {
        ConsoleCommand consoleCommand = new ConsoleCommand.Builder()
                .addData(true)
                .statistic(SIMPLE)
                .resultPath("/some/path")
                .prefix("/result_")
                .inputFilePaths("input.txt",
                        "input2.txt")
                .build();
        ContentsFilter filter = new ContentsFilter(consoleCommand);
        filter.execute();
    }
}
