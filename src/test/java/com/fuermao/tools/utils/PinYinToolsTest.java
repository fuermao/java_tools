package com.fuermao.tools.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PinYinToolsTest {
    private static final Logger log = LoggerFactory.getLogger(PinYinToolsTest.class);

    @Test
    void getPinYin() {
        String name = CreateNameTools.createName();
        String result = PinYinTools.getPinYin(name);
        log.info("{} 转换成拼音为：{}",name,result);
        assertNotNull(result);
    }
}