package com.fuermao.tools.constant;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <h1>FileTypeTest</h1>
 * <p>FileType 的单元测试</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/14</li>
 * </ul>
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileTypeTest {

	static Stream<Integer> fileTypeIndexProvider(){
		FileType[] values = FileType.values();
		return Stream.of(values).map(FileType::ordinal);
	}

	static Stream<String> fileTypeSuffixProvider(){
		FileType[] values = FileType.values();
		return Stream.of(values).map(FileType::getSuffix);
	}

	@Order(1)
	@ParameterizedTest
	@DisplayName("根据索引值测试")
	@MethodSource("fileTypeIndexProvider")
	void getFileType(int index) {
		FileType type = FileType.getFileType(index);
		Assertions.assertNotNull(type);
	}

	@Order(2)
	@ParameterizedTest
	@DisplayName("根据文件的后缀测试")
	@MethodSource("fileTypeSuffixProvider")
	void testGetFileType(String suffix) {
		FileType type = FileType.getFileType(suffix);
		Assertions.assertNotNull(type);
	}
}