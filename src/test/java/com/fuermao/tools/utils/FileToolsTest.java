package com.fuermao.tools.utils;

import com.fuermao.tools.constant.FileType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileToolsTest {
	// 日志记录器
	private static final Logger log = LoggerFactory.getLogger(FileToolsTest.class);

	@DisplayName("测试生成文件名称")
	@ParameterizedTest
	@ValueSource(booleans = {true,false})
	void createTempFileName(boolean isTemp) {
		String fileName = FileTools.createTempFileName(isTemp, FileType.PNG);
		log.debug("生成的文件名为：{}",fileName);
		if(isTemp)
			assertTrue(fileName.contains("temp"));
		else
			assertNotNull(fileName);
	}
}