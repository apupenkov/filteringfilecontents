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
                    logger.info("- min number:        {}", statisticService.getMinIntValue());
                    logger.info("- max number:        {}", statisticService.getMaxIntValue());
                    logger.info("- number sum:        {}", statisticService.getSumIntValue());
                    logger.info("- average number:    {}", statisticService.getAvgIntValue());
                    logger.info("- min decimal:       {}", statisticService.getMinDoubleValue());
                    logger.info("- max decimal:       {}", statisticService.getMaxDoubleValue());
                    logger.info("- decimal sum:       {}", statisticService.getSumDoubleValue());
                    logger.info("- average decimal:   {}", statisticService.getAvgDoubleValue());
                    logger.info("- max string length: {}", "\"" + statisticService.getMaxString() + "\"");
                    logger.info("- min string length: {}", "\"" + statisticService.getMinString() + "\"");
                }
            }
        }
    }

    private void shortDisplay() {
        logger.info("Found in the process of filtering:");
        logger.info("- numbers count:     {}", statisticService.getIntSize());
        logger.info("- decimals count:    {}", statisticService.getFloatSize());
        logger.info("- strings count:     {}", statisticService.getStringSize());
    }
}