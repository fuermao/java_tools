package com.fuermao.tools.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统计代码运行时间
 */
public class StatisticsRunTimeTools {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsRunTimeTools.class);
    public static void statistic(IStatisticsRunTimes statisticsRunTimes){
        long start = System.currentTimeMillis();
        statisticsRunTimes.run();
        long end = System.currentTimeMillis();
        long result = end - start;
        logger.debug("运行了 {} 毫秒！",result);
    }
}
