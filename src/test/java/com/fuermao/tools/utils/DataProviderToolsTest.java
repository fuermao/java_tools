package com.fuermao.tools.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1></h1>
 * <p></p>
 *
 * <ul>
 *  <li>@author：Mr.FuErMao</li>
 *  <li>@date：2024/06/21</li>
 * </ul>
 */
class DataProviderToolsTest {
    /**
     * 日志记录器
     */
    private static final Logger log = LoggerFactory.getLogger(DataProviderToolsTest.class);
    
    @RepeatedTest(10)
    @DisplayName("测试手机号码生成")
    void mobile() {
        String mobile = DataProviderTools.mobile();
        log.debug("mobile = {}",mobile);
        assertEquals(11,mobile.length());
    }
    
    @RepeatedTest(10)
    @DisplayName("测试邮箱生成")
    void email() {
        String email = DataProviderTools.email();
        log.debug("email = {}",email);
        assertTrue(email.contains("@"));
    }
}