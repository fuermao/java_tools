package com.fuermao.tools.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StatisticsRunTimeToolsTest {

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
    }
}