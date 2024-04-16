package com.fuermao.tools.utils.mime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * <h1></h1>
 * <p></p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/16</li>
 * </ul>
 */
class LoadMIMEFileTest {
	private static final Logger log = LoggerFactory.getLogger(LoadMIMEFileTest.class);

	static Stream<String> mimeTypeProvider() {
		return Stream.of("application", "audio","font", "image", "message", "model", "multipart", "text", "video");
	}

	@ParameterizedTest
	@MethodSource("mimeTypeProvider")
	void load(String mimeType) {
		HashMap<String, String> map = new HashMap<>();
		assertDoesNotThrow(() -> {
			LoadMIMEFile loadMIMEFile = new LoadMIMEFile(mimeType);
			loadMIMEFile.load(map);
		});
		log.info("{} 的 map 大小为：{}",mimeType, map.size());
		assertFalse(map.isEmpty());
	}
}