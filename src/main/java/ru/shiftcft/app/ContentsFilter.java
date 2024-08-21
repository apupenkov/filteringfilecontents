package ru.shiftcft.app;

import ru.shiftcft.data.Basket;
import ru.shiftcft.utils.ConsoleCommand;
import ru.shiftcft.utils.FileHandler;

public class ContentsFilter {

    private final ConsoleCommand consoleCommand;
    private final FileHandler fileHandler = new FileHandler();

    public ContentsFilter(ConsoleCommand consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    public void execute() {
        Basket basket = fileHandler.readInputFiles(consoleCommand.getInputFilePaths());
        String filePathPart = consoleCommand.getResultPath() + "/" + consoleCommand.getPrefix();
        fileHandler.writeDataToFile(filePathPart + "integers.txt", basket.getInts(), consoleCommand.appendData());
        fileHandler.writeDataToFile(filePathPart + "floats.txt", basket.getFloats(), consoleCommand.appendData());
        fileHandler.writeDataToFile(filePathPart + "strings.txt", basket.getStrings(), consoleCommand.appendData());
    }
}
