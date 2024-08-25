package ru.shiftcft.app.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.regex.Pattern;

import static ru.shiftcft.app.console.ConsoleCommand.StatisticType.FULL;
import static ru.shiftcft.app.console.ConsoleCommand.StatisticType.SHORT;

public enum Command {

    A("-a") {
        boolean parameterExist() {
            return false;
        }
        boolean paramIsCorrect(String param) { return true; }
        void addCommand(String commandParameters) {
            commandBuilder.addData(true);
        }
    },
    S("-s") {
        boolean parameterExist() { return false; }
        boolean paramIsCorrect(String param) { return true; }
        void addCommand(String commandParameters){
            commandBuilder.statistic(SHORT);
        }
    },
    F("-f") {
        boolean parameterExist() { return false; }
        boolean paramIsCorrect(String param) { return true; }
        void addCommand(String commandParameters){
            commandBuilder.statistic(FULL);
        }
    },
    O("-o") {
        boolean parameterExist() { return true; }
        boolean paramIsCorrect(String param) {
            if(Pattern.matches("^([/\\\\][^<>:\\\\;@!«/|\\[,\\]?*=#%&+ ]+)+$", param)) {
                return true;
            }
            logger.error("Путь к папке результата указан некорректно. Убедитесь, " +
                        "что после флага \"-o\" указан путь к файлу " +
                        "и в нем отсутствуют симводы <>:;@!« /|[,]?*=#%&+\n" +
                        "Текущие результаты будут сохранены в папке " + "\"" + rootPath + "\"");
            return false;
        }
        void addCommand(String commandParameters){
            String path = commandParameters.replace("\\\\", File.separator)
                    .replace("/", File.separator);
            commandBuilder.resultPath(rootPath + path);
        }
    },
    P("-p") {
        boolean parameterExist() { return true; }
        boolean paramIsCorrect(String param) {
            if(Pattern.matches("^[^<>:;@!«/|\\[,\\].?*=#%&+ ]+_{1}$", param)) {
                return true;
            }
            logger.error("Префикс файла результата указан некорректно. Убедитесь, " +
                    "что после флага \"-p\" указан префикс файла;" +
                    "и в нем отсутствуют симводы <>:;@!«/| [,]?*=#%&+\n" +
                    "Файл результата будет назван по умолчанию");
            return false;
        }
        void addCommand(String commandParameters){
            String prefix = commandParameters.replace("\\", "")
                .replace("/", "");
            commandBuilder.prefix(prefix);
        }
    },
    DEFAULT("default") {
        boolean parameterExist() { return false; }
        boolean paramIsCorrect(String param) {
            if(Pattern.matches("^[^<>:;@!«/|\\[.,\\]?*=#%&+ ]+\\.txt$", param)){
                return true;
            }
            logger.error("Путь к исходному файлу указан некорректно");
            return false;
        }
        void addCommand(String fileName){
            commandBuilder.addFilePath(fileName);
        }
    };

    private final String name;
    private static final ConsoleCommand.Builder commandBuilder = new ConsoleCommand.Builder();
    private static final String rootPath = System.getProperty("user.dir");
    private static final Logger logger = LogManager.getLogger(Command.class);

    static {
        commandBuilder.addData(false).resultPath(rootPath);
    }

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract boolean parameterExist();

    abstract boolean paramIsCorrect(String param);

    abstract void addCommand(String commandParameters);

    public static ConsoleCommand getCommands() {
        return commandBuilder.build();
    }
}