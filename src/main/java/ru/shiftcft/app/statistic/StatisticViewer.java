package ru.shiftcft.app.statistic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.shiftcft.app.console.ConsoleCommand.StatisticType;

public class StatisticViewer {

    private final StatisticType type;
    private final StatisticService statisticService;
    private static final Logger logger = LogManager.getLogger(StatisticViewer.class);

    public StatisticViewer(StatisticType type, StatisticService statisticService) {
        this.type = type;
        this.statisticService = statisticService;
    }

    public void displayStatistics() {
        if(type != null) {
            switch (type) {
                case SHORT: {
                    shortDisplay();
                }
                break;
                case FULL: {
                    shortDisplay();
                    logger.info("- наименьшее целое число: " + statisticService.getMinIntValue());
                    logger.info("- наибольшее целое число: " + statisticService.getMaxIntValue());
                    logger.info("- сумма целых чисел: " + statisticService.getSumIntValue());
                    logger.info("- среднее значение целых чисел: " + statisticService.getAvgIntValue());
                    logger.info("- строка с максимальной длиной: " + "\"" + statisticService.getMaxString() + "\"");
                    logger.info("- строка с минимальной длиной: " + "\"" + statisticService.getMinString() + "\"");
                }
            }
        }
    }

    private void shortDisplay() {
        logger.info("В процессе фильтрации найдено:");
        logger.info("- целых чисел: " + statisticService.getIntSize());
        logger.info("- вещественных чисел: "+ statisticService.getFloatSize());
        logger.info("- строк: "+ statisticService.getStringSize());
    }
}
