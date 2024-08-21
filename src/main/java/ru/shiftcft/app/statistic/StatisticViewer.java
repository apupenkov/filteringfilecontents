package ru.shiftcft.app.statistic;

import ru.shiftcft.app.console.ConsoleCommand.StatisticType;

public class StatisticViewer {

    private final StatisticType type;
    private final StatisticService statisticService;

    public StatisticViewer(StatisticType type, StatisticService statisticService) {
        this.type = type;
        this.statisticService = statisticService;
    }

    public void displayStatistics() {
        switch (type) {
            case SHORT: {
                shortDisplay();
            } break;
            case FULL: {
                shortDisplay();
                System.out.println("- наименьшее целое число: " + statisticService.getMinIntValue());
                System.out.println("- наибольшее целое число: " + statisticService.getMaxIntValue());
                System.out.println("- сумма целых чисел: " + statisticService.getSumIntValue());
                System.out.println("- среднее значение целых чисел: " + statisticService.getAverageIntValue());
                System.out.println("- строка с максимальной длиной: " + "\"" + statisticService.getMaxString() + "\"");
                System.out.println("- строка с минимальной длиной: "  + "\"" + statisticService.getMinString() + "\"");
            }
        }
    }

    private void shortDisplay() {
        System.out.println("В процессе фильтрации найдено:");
        System.out.println("- целых чисел: " + statisticService.getIntSize());
        System.out.println("- вещественных чисел: "+ statisticService.getFloatSize());
        System.out.println("- строк: "+ statisticService.getStringSize());
    }
}
