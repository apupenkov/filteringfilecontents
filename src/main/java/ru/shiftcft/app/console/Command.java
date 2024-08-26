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
            logger.error("The path to the result folder is specified incorrectly. Make sure that the " +
                    "file path is specified after the \"-o\" flag " +
                    "and that it does not contain the <>:;@!« /|[,]?*=#%&+\n" +
                    "The current results will be saved in the folder " + "\"" + rootPath + "\"");
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
            if(Pattern.matches("^[^<>:;@!«/|\\[,\\].?*=#%&+ ]+$", param)) {
                return true;
            }
            logger.error("The output file prefix is​specified incorrectly. Make sure that the " +
                    "file prefix specified after the \"-p\" flag is " +
                    "and that it does not contain the <>:;@!«/| [,]?*=#%&+\n" +
                    "The output file will be named by default");
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
            logger.error("The path to the source file is incorrect");
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