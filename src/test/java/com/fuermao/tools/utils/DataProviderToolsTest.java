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

    @RepeatedTest(10)
    @DisplayName("测试生成账号")
    void account() {
        String account = DataProviderTools.account();
        log.debug("account = {}",account);
        assertTrue(account.length() >= 6 && account.length() <= 15);
    }

    @RepeatedTest(10)
    @DisplayName("测试生成账号")
    void testAccount() {
        String account = DataProviderTools.account(true);
        log.debug("account by 拼音 = {}，长度：{}",account,account.length());
        assertTrue(account.length() >= 6 && account.length() <= 15);
    }

    @RepeatedTest(10)
    @DisplayName("测试生成随机强密码")
    void passwordTest() {
        String password = DataProviderTools.password();
        log.debug("password = {}，强密码长度：{}",password,password.length());
        assertTrue(password.length() >= 6 && password.length() <= 18);
    }

    @RepeatedTest(10)
    @DisplayName("测试随机生成弱密码")
    void password() {
        String password = DataProviderTools.password(null,false);
        log.debug("password = {}，弱密码长度：{}",password,password.length());
        assertTrue(password.length() >= 6 && password.length() <= 18);
    }
}