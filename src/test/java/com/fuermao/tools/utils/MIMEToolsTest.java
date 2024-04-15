package com.fuermao.tools.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1></h1>
 * <p></p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MIMEToolsTest {
    static MIMETools mime;
    
    @BeforeAll
    static void beforeAll(){
        mime = MIMETools.getInstance();
    }
    
    @Test
    void parseMIME() {
        System.out.println(11);
    }
}