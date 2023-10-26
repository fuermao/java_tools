package com.fuermao.tools.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CreateNameToolsTest {
	protected static final Logger log = LoggerFactory.getLogger(CreateNameToolsTest.class);

	@DisplayName("随机生成名字测试")
	@RepeatedTest(value = 10, name = "第 {currentRepetition}/{totalRepetitions} 次 {displayName}")
	void createName(RepetitionInfo info) {
		String name = CreateNameTools.createName();
		log.debug("第 {}/{} 次测试，生成的名字是：{}。", info.getCurrentRepetition(), info.getTotalRepetitions(), name);
	}

	@DisplayName("生成指定长度的名字")
	@ParameterizedTest(name = "传入的第 {index} 个值为：{arguments}")
	@ValueSource(ints = {0, 1, 2, 3, 4, 10, 20})
	void testCreateName(int nameLen) {
		String name = CreateNameTools.createName(nameLen);
		log.debug("指定的名字长度为：{}，生成的名字是：{}", nameLen, name);
	}
}