package com.fuermao.tools.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

class CreateCarNumberToolsTest {

	@RepeatedTest(4)
	@DisplayName("简单新能源车牌号生成测试")
	void simpleNewEnergyVehiclesNumber() {
		String s = CreateCarNumberTools.simpleRandomNewEnergyVehiclesCarNumber();
		System.out.println(s);
	}

	@RepeatedTest(4)
	@DisplayName("简单车牌号生成测试不区分新能源和燃油车")
	void simpleCreateCarNumber() {
		Random random = new Random();
		String s = CreateCarNumberTools.simpleRandomCreateCarNumber(random.nextBoolean());
		System.out.println(s);
	}

	@RepeatedTest(4)
	@DisplayName("简单燃油车车牌号生成测试")
	void simpleNormalCarNumber() {
		String s = CreateCarNumberTools.simpleRandomNormalCarNumber();
		System.out.println(s);
	}
}