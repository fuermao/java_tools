package com.fuermao.tools.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * 统计代码运行时间
 */
public class StatisticsRunTimeTools {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsRunTimeTools.class);

    /**
     * 计算程序运行消耗的时间
     * @param statisticsRunTimes IStatisticsRunTimes 统计运行程序的代码
     * @return long 默认返回的是运行的毫秒数
     */
    private static long count(IStatisticsRunTimes statisticsRunTimes){
        return statisticRuntimesAndReturn(statisticsRunTimes,TimeUnit.MILLISECONDS);
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

    /**
     * 返回程序运行时间，根据时间单位进行范围
     * @param statisticsRunTimes IStatisticsRunTimes 需要被统计运行时间的代码
     * @param unit TimeUnit 时间单位，如：TimeUnit.NANOSECONDS 即可。
     * @return long 返回值
     */
    public static long statisticRuntimesAndReturn(IStatisticsRunTimes statisticsRunTimes, TimeUnit unit){
        Instant start = Instant.now();
        statisticsRunTimes.run();
        Instant end = Instant.now();
        Duration result = Duration.between(start,end);
        switch (unit){
            case NANOSECONDS:
                return result.toNanos();
            case MICROSECONDS:
                return TimeUnit.NANOSECONDS.toMicros(result.toNanos());
            case SECONDS:
                return TimeUnit.NANOSECONDS.toSeconds(result.toNanos());
            case MINUTES:
                return TimeUnit.NANOSECONDS.toMinutes(result.toNanos());
            case HOURS:
                return TimeUnit.NANOSECONDS.toHours(result.toNanos());
            case DAYS:
                return TimeUnit.NANOSECONDS.toDays(result.toNanos());
            default:
                return TimeUnit.NANOSECONDS.toMillis(result.toNanos());
        }
    }
}
