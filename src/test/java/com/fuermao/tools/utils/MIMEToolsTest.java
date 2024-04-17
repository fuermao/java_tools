package com.fuermao.tools.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

	protected static final Logger log = LoggerFactory.getLogger(MIMEToolsTest.class);

    static MIMETools mime;
    
    @BeforeAll
    static void beforeAll(){
        mime = MIMETools.getInstance();
    }

	@ParameterizedTest
	@ValueSource(strings={"application/json","image/jpeg"})
    void parseMIME(String mimeType) {
		String fileSuffix = mime.parseMIME(mimeType);
		log.info("mimeType:{},fileSuffix:{}",mimeType,fileSuffix);
		assertNotNull(fileSuffix);
	}
}