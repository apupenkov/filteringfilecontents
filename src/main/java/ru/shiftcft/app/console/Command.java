package ru.shiftcft.app.console;

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
            System.out.println("Путь к папке результата указан некорректно.\n" +
                        "Убедитесь, что в нем отсутствуют симводы <>:;@!« /|[,]?*=#%&+\n" +
                        "Текущие результаты будут сохранены в папке " + rootPath);
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
            System.out.println("Префикс файла результата указан некорректно\n" +
                    "Убедитесь, что в нем отсутствуют симводы <>:;@!«/| [,]?*=#%&+\n" +
                    "Файл результата будет назван по умолчанию");
            return false;
        }
        void addCommand(String commandParameters){
            String prefix = commandParameters.replace("\\", "")
                .replace("/", "");
            commandBuilder.prefix(prefix);
        }
    },
    DEFAULT("file") {
        boolean parameterExist() { return false; }
        boolean paramIsCorrect(String param) {
            if(Pattern.matches("^[^<>:;@!«/|\\[.,\\]?*=#%&+ ]+\\.txt$", param)){
                return true;
            }
            System.out.println("Путь к исходному файлу указан некорректно");
            return false;
        }
        void addCommand(String fileName){
            commandBuilder.addFilePath(fileName);
        }
    };

    private final String name;
    private static final ConsoleCommand.Builder commandBuilder = new ConsoleCommand.Builder();
    private static final String rootPath = System.getProperty("user.dir");

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