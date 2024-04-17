package com.fuermao.tools.utils.mime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1></h1>
 * <p></p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/16</li>
 * </ul>
 */
class ApplicationTest {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

	@Test
	void test(){
		MIME application = new Application();
		String file = application.getCSVFile();
		logger.debug("{}",file);
	}

}