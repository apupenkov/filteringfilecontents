package ru.shiftcft.utils;

import java.util.regex.Pattern;

import static ru.shiftcft.utils.ConsoleCommand.StatisticType.FULL;
import static ru.shiftcft.utils.ConsoleCommand.StatisticType.SIMPLE;

public class ConsoleCommandParser {

    public ConsoleCommand getCommand(String... args) {
        String rootPath = System.getProperty("user.dir");
        ConsoleCommand.Builder commandBuilder = new ConsoleCommand.Builder();
        commandBuilder.addData(false).resultPath(rootPath);
        for (int i = 0; i < args.length; i++) {
            try {
                switch (args[i]) {
                    case "-a": commandBuilder.addData(true);
                        break;
                    case "-s": commandBuilder.statistic(SIMPLE);
                        break;
                    case "-f": commandBuilder.statistic(FULL);
                        break;
                    case "-o": {
                        if((i+1) < args.length && Pattern.matches("^(/[^<>:;@!«/|\\[,\\]?*=#%&+ ]+)+$", args[i + 1])) {
                            commandBuilder.resultPath("");
                            i++;
                        } else {
                            System.out.println("Путь к папке результата указан некорректно.\n" +
                                    "Убедитесь, что в нем отсутствуют симводы <>:;@!« /|[,]?*=#%&+\n" +
                                    "Текущие результаты будут сохранены в папке " + rootPath);
                        }
                        break;
                    }
                    case "-p": {
                        if((i+1) < args.length && Pattern.matches("^[^<>:;@!«/|\\[,\\]?*=#%&+ ]+_$", args[i + 1])) {
                            commandBuilder.resultPath("");
                            i++;
                        }
                    }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неизвестная команда: " + args[i]);
            }
        }
        return commandBuilder.build();
    }
}
