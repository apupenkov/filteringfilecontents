package ru.shiftcft.app.filter;

import ru.shiftcft.app.console.ConsoleCommand;
import ru.shiftcft.app.statistic.StatisticService;
import ru.shiftcft.app.statistic.StatisticViewer;
import ru.shiftcft.data.Basket;
import ru.shiftcft.utils.FileHandler;

import java.io.File;

public class ContentsFilter {

    private final ConsoleCommand consoleCommand;
    private final FileHandler fileHandler = new FileHandler();

    public ContentsFilter(ConsoleCommand consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    public void execute() {
        Basket basket = fileHandler.readInputFiles(consoleCommand.getInputFilePaths());
        StatisticViewer statisticViewer = new StatisticViewer(consoleCommand.getStatistic(), new StatisticService(basket));
        String filePathPart = consoleCommand.getResultPath() + File.separator + consoleCommand.getPrefix();
        fileHandler.mkDir(consoleCommand.getResultPath());
        fileHandler.writeIntegerDataToFile(filePathPart + "integers.txt", basket.getInts(), consoleCommand.appendData());
        fileHandler.writeIntegerDataToFile(filePathPart + "floats.txt", basket.getDoubles(), consoleCommand.appendData());
        fileHandler.writeStringDataToFile(filePathPart + "strings.txt", basket.getStrings(), consoleCommand.appendData());
        statisticViewer.displayStatistics();
    }
}
