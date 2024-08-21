package ru.shiftcft.app.console;

import java.util.ArrayList;

public class ConsoleCommand {
    private String resultPath, prefix;
    private StatisticType statistictype;
    private boolean isAppend;
    private ArrayList<String> inputFilePaths;

    private ConsoleCommand(Builder builder) {
        this.statistictype = builder.statistictype;
        this.resultPath = builder.resultPath;
        this.prefix = builder.prefix;
        this.isAppend = builder.isAppend;
        this.inputFilePaths = builder.inputFilePaths;
    }

    public StatisticType getStatistic() {
        return statistictype;
    }

    public String getResultPath() {
        return resultPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean appendData() {
        return isAppend;
    }

    public ArrayList<String> getInputFilePaths() {return inputFilePaths;}

    public static class Builder {
        private String resultPath, prefix;
        private StatisticType statistictype;
        private boolean isAppend;
        private final ArrayList<String> inputFilePaths = new ArrayList<>();

        public Builder statistic(StatisticType statistictype) {
            this.statistictype = statistictype;
            return this;
        }

        public Builder addFilePath(String filePath) {
            inputFilePaths.add(filePath);
            return this;
        }

        public Builder resultPath(String resultPath) {
            this.resultPath = resultPath;
            return this;
        }

        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder addData(boolean addData) {
            this.isAppend = addData;
            return this;
        }

        public ConsoleCommand build() {
            return new ConsoleCommand(this);
        }

    }

    public enum StatisticType {
        FULL("-f"), SHORT("-s");
        private final String command;
        StatisticType(String command) {
            this.command = command;
        }
        public String getCommand() {
            return command;
        }
    }
}
