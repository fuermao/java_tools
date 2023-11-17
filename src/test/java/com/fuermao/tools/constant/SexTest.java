package com.fuermao.tools.constant;

import com.fuermao.tools.exception.SexEnumException;
import com.fuermao.tools.utils.LogToLogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SexTest {
	private static final Logger log = LoggerFactory.getLogger(SexTest.class);

	@ParameterizedTest
	@ValueSource(ints = {- 1, 0, 1, 2})
	void getSexByIndex(int index) {
		if (index < 0 || index >= Sex.values().length) {
			SexEnumException exception = assertThrows(SexEnumException.class, () -> {
				Sex sex = Sex.getSexByIndex(index);
				log.info("{}", sex);
			});
			LogToLogger.throwableToLogger(exception, log);
		} else {
			assertDoesNotThrow(() -> {
				Sex sex = Sex.getSexByIndex(index);
				log.info("{}", sex);
			});
		}
	}
}