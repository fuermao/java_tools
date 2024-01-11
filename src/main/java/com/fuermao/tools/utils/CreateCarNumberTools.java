package com.fuermao.tools.utils;

import java.util.Random;

/**
 * 车牌号工具类
 */
public class CreateCarNumberTools {
	private static final String PROVINCES = "京津沪渝冀晋辽吉黑苏浙皖闽赣鲁豫鄂湘粤琼川贵云陕甘青台蒙桂藏宁新港澳";
	private static final String LETTERS = "ABCDEFGHJKLMNPQRSTUVWXYZ";
	private static final String NEW_ENERGY_VEHICLES_LETTERS = "ABCDEFGHJK";
	private static final String NUMBERS = "0123456789";

	private static final Random random = new Random();

	/**
	 * 随机生成车牌号码归属地
	 * @return String 归属地
	 */
	private static String simpleRandomCreatePlaceOfAttribution(){
		return String.valueOf(PROVINCES.charAt(random.nextInt(PROVINCES.length()))) +
				LETTERS.charAt(random.nextInt(LETTERS.length())) +
				" ";
	}

	/**
	 * 随机生成车牌牌
	 * @param isNewEnergyVehicles boolean 是否是新能源汽车
	 * @return String 车牌号
	 */
	public static String simpleRandomCreateCarNumber(boolean isNewEnergyVehicles){
		if (isNewEnergyVehicles)
			return simpleRandomNewEnergyVehiclesCarNumber();
		else
			return simpleRandomNormalCarNumber();
	}

	/**
	 * 随机生成普通燃油车车牌号码
	 * @return String 车牌号
	 */
	public static String simpleRandomNormalCarNumber(){
		// 车牌前缀——归属地
		StringBuilder licensePlate = new StringBuilder(simpleRandomCreatePlaceOfAttribution());
		for (int i = 0; i < 5; i++) {
			boolean isLetters = random.nextBoolean();
			if(isLetters){
				licensePlate.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
			} else {
				licensePlate.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
			}
		}
		return licensePlate.toString();
	}


	/**
	 * 随机生成新能源车牌
	 * @return String 车牌号
	 */
	public static String simpleRandomNewEnergyVehiclesCarNumber(){
		// 车牌前缀
		StringBuilder carLicensePlate = new StringBuilder(simpleRandomCreatePlaceOfAttribution());
		StringBuilder number = new StringBuilder();
		// 车牌号
		for (int i = 0; i < 6; i++) {
			if(i == 0){
				number.append(NEW_ENERGY_VEHICLES_LETTERS.charAt(random.nextInt(NEW_ENERGY_VEHICLES_LETTERS.length())));
				continue;
			}
			number.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
		}
		boolean isReverse = random.nextBoolean();
		// 如果字母在最前面则说明是小型新能源汽车。
		// 如果字母在最后面则说明是大型新能源汽车。
		if(isReverse)
			number.reverse();
		carLicensePlate.append(number);
		return carLicensePlate.toString();
	}
}
