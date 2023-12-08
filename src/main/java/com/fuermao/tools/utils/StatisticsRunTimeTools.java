package com.fuermao.tools.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统计代码运行时间
 */
public class StatisticsRunTimeTools {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsRunTimeTools.class);

    private static long count(IStatisticsRunTimes statisticsRunTimes){
        long start = System.currentTimeMillis();
        statisticsRunTimes.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 计算程序运行消耗的时间
     * @param statisticsRunTimes IStatisticsRunTimes 需要被计时的应用
     */
    public static void statistic(IStatisticsRunTimes statisticsRunTimes){
        long count = count(statisticsRunTimes);
        logger.debug("运行了 {} 毫秒！",count);
    }

    /**
     * 计算程序运行消耗的时间
     * @param name String 应用名称
     * @param statisticsRunTimes IStatisticsRunTimes 需要被计时的应用
     */
    public static void statistic(String name,IStatisticsRunTimes statisticsRunTimes){
        long result = count(statisticsRunTimes);
        logger.debug("{} 运行了 {} 毫秒！",name,result);
    }
}
