package com.fuermao.tools.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

class AgeSegmentationTest {

	/**
	 * 日志器
	 */
	private static final Logger log = LoggerFactory.getLogger(AgeSegmentationTest.class);

	@ParameterizedTest
	@EnumSource(AgeSegmentation.class)
	void testWithEnumSource(AgeSegmentation ageSegmentation) {
		Assertions.assertNotNull(ageSegmentation);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 7})
	void getAgeSegmentationByIndex(int index) {
		AgeSegmentation[] ageSegmentations = AgeSegmentation.values();
		if (index < ageSegmentations.length) {
			Assertions.assertDoesNotThrow(() -> {
				AgeSegmentation.getAgeSegmentationByIndex(index);
			});
		} else {
			EnumConstantNotPresentException exception = Assertions.assertThrows(EnumConstantNotPresentException.class, () -> AgeSegmentation.getAgeSegmentationByIndex(index));
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			log.debug(stringWriter.toString());
		}
	}


	@DisplayName("年龄分段测试")
	@ParameterizedTest
	@ValueSource(ints = {- 1, 0, 1, 6, 7, 8, 12, 17, 18, 35, 45, 46, 50, 69, 70, 80, 120, 121})
	void judgeAgeSegmentation(int age) {
		if (age < AgeSegmentation.getSegmentationAgeMin() || age > AgeSegmentation.getSegmentationAgeMax()) {
			Exception exception = Assertions.assertThrows(EnumConstantNotPresentException.class, () -> AgeSegmentation.judgeAgeSegmentation(age));
			StringWriter stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			exception.printStackTrace(writer);
			log.debug(stringWriter.toString());
		} else {
			Assertions.assertDoesNotThrow(() -> {
				AgeSegmentation segmentation = AgeSegmentation.judgeAgeSegmentation(age);
				log.info(segmentation.toString());
			});
		}
	}

	@DisplayName("年龄范围测试")
	@ParameterizedTest(name = "{displayName}传入参数：{arguments}")
	@ValueSource(ints = {- 1, 0, 2, 56, 88, 120, 121})
	void judgeAgeRange(int age) {
		int min = AgeSegmentation.getSegmentationAgeMin();
		int max = AgeSegmentation.getSegmentationAgeMax();
		if (age < min || age > max) {
			Assertions.assertFalse(AgeSegmentation.judgeAgeRange(age));
		} else {
			Assertions.assertTrue(AgeSegmentation.judgeAgeRange(age));
		}
	}
}