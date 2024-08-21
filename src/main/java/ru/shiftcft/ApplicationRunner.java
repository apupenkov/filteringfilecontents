package ru.shiftcft;

import ru.shiftcft.app.console.ConsoleCommandParser;
import ru.shiftcft.app.filter.ContentsFilter;
import ru.shiftcft.app.console.ConsoleCommand;

public class ApplicationRunner {

    public static void main(String[] args) {
        ConsoleCommand consoleCommand = new ConsoleCommandParser().commandConstruct(args);
        ContentsFilter filter = new ContentsFilter(consoleCommand);
        filter.execute();
    }
}
