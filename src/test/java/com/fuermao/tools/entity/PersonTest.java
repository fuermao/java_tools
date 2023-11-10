package com.fuermao.tools.entity;

import com.fuermao.tools.constant.AgeSegmentation;
import com.fuermao.tools.exception.AgeSegmentationEnumException;
import com.fuermao.tools.utils.LogToLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Person Entity 测试")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonTest {

	private static final Logger logger = LoggerFactory.getLogger(PersonTest.class);

	private Person p1;

	private Person p2;

	@BeforeAll
	void before() {
		p1 = new Person();
		p1.setName();
		p1.setAge();
		p2 = new Person("张三", 88);
	}

	@Test
	void test() {
		logger.debug(p1.toString());
		logger.debug(p2.toString());
		logger.debug("{} 的年龄是：{} 岁。", p1.getName(), p1.getAge());
		logger.debug("{} 的年龄是：{} 岁。", p2.getName(), p2.getAge());
	}

	@Test
	@DisplayName("测试实体类的 Hash 值")
	void testHashCode() {
		int hashCode1 = p1.hashCode();
		String s1 = Integer.toHexString(hashCode1);
		String hexString1 = Integer.toHexString(System.identityHashCode(p1));

		int hashCode2 = p2.hashCode();
		String s2 = Integer.toHexString(hashCode2);
		String hexString2 = Integer.toHexString(System.identityHashCode(p2));
		Assertions.assertEquals(hexString1, s1);
		Assertions.assertEquals(hexString2, s2);
		logger.debug("person1（{}）的 hashCode 为：{}，转为十六进制为：{}，系统生成的 Hash 值为：{}", p1, hashCode1, s1, hexString1);
		logger.debug("person2（{}）的 hashCode 为：{}，转为十六进制为：{}，系统生成的 Hash 值为：{}", p2, hashCode2, s2, hexString2);
	}

	@ParameterizedTest
	@DisplayName("测试修改年龄，年龄分段信息是否会同时修改")
	@ValueSource(ints = {- 1, 0, 8, 18, 22, 80, 120, 130})
	void setAge(int age) {
		// 获取修改之前的年龄
		int beforeAge = p1.getAge();
		if (age < 0 || age > AgeSegmentation.getSegmentationAgeMax()) {
			AgeSegmentationEnumException exception = Assertions.assertThrows(AgeSegmentationEnumException.class, () -> p1.setAge(age));
			logger.debug("修改前的年龄是：{}，修改后的年龄是：{}", beforeAge, p1.getAge());
			// 判断是否相等
			Assertions.assertEquals(beforeAge, p1.getAge());
			LogToLogger.throwableToLogger(exception, logger);
		} else {
			Assertions.assertDoesNotThrow(() -> p1.setAge(age));
			logger.debug("修改前的年龄是：{}，修改后的年龄是：{}", beforeAge, p1.getAge());
			Assertions.assertNotEquals(beforeAge, p1.getAge());
		}
		AgeSegmentation p1Segmentation = p1.getSegmentation();
		logger.info(p1Segmentation.toString());
	}

	@DisplayName("随机生成年龄")
	@RepeatedTest(value = 10, name = "第 {currentRepetition}/{totalRepetitions} 次{displayName}")
	void setAge() {
		int beforeAge = p1.getAge();
		AgeSegmentation beforeAgeSegmentation = p1.getSegmentation();
		logger.info(
				"修改前的年龄是：{}，对应的年龄分段信息：{}，其范围是：{}~{}",
				beforeAge,
				beforeAgeSegmentation.getDisplayName(),
				beforeAgeSegmentation.getMinAge(),
				beforeAgeSegmentation.getMaxAge()
		);
		p1.setAge();
		int age = p1.getAge();
		AgeSegmentation segmentation = p1.getSegmentation();
		logger.info(
				"修改后的年龄是：{}，对应的年龄分段信息：{}，其范围是：{}~{}",
				age,
				segmentation.getDisplayName(),
				segmentation.getMinAge(),
				segmentation.getMaxAge()
		);
		Assertions.assertNotEquals(age,beforeAge);
	}
}