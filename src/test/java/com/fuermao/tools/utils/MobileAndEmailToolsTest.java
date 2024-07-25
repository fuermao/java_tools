package com.fuermao.tools.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MobileAndEmailToolsTest {
    private static final Logger log = LoggerFactory.getLogger(MobileAndEmailToolsTest.class);

    @Test
    void createMobile() {
        String mobile = MobileAndEmailTools.createMobile();
        log.info("mobile: {}", mobile);
        assertEquals(11, mobile.length());
    }

    @Test
    void createEmail() {
        String email = MobileAndEmailTools.createEmail();
        log.info("email: {}", email);
        assertNotNull(email);
    }
}