package com.fuermao.tools.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StatisticsRunTimeToolsTest {
    public static final Logger LOGGER =  LoggerFactory.getLogger(StatisticsRunTimeToolsTest.class);

    @Test
    @DisplayName("测试方法执行的时间")
    void statistic() {
        assertDoesNotThrow(()->{
            IStatisticsRunTimes times = () -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            StatisticsRunTimeTools.statistic(times);
        });

        assertDoesNotThrow(()->{
            IStatisticsRunTimes times = () -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            StatisticsRunTimeTools.statistic("这是测试运行时间的程序",times);
        });
    }

    @Test
    @DisplayName("测试时间差值的计算")
    void test() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(3000);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        long result = between.toMillis();
        LOGGER.debug("{}",result);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class)
    void statisticRuntimesAndReturn(TimeUnit unit) {
        long l = StatisticsRunTimeTools.statisticRuntimesAndReturn(() -> {
	        try {
		        TimeUnit.SECONDS.sleep(3);
	        } catch (InterruptedException e) {
		        LogToLogger.throwableToLogger(e,LOGGER);
	        }
        }, unit);
        LOGGER.debug("{}",l);
    }
}