package com.fuermao.tools.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LogToLoggerTest {

	private static Logger logger;

	@BeforeAll
	static void before(){
		logger = LoggerFactory.getLogger(LogToLoggerTest.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"测试日志输出信息"})
	void log(String string) {
		LogToLogger.log(string,logger,Level.ERROR);
	}

	@Test
	void throwableToLogger() {
		ClassNotFoundException classNotFoundException = assertThrows(ClassNotFoundException.class, () -> {
			Class.forName("com.fuermao.tools.Dog");
		});
		LogToLogger.throwableToLogger(classNotFoundException,logger);
	}

	@Test
	void testThrowableToLogger() {
		ClassNotFoundException classNotFoundException = assertThrows(ClassNotFoundException.class, () -> {
			Class.forName("com.fuermao.tools.Dog");
		});
		LogToLogger.throwableToLogger("未找到指定的类！",classNotFoundException,logger);
	}
}