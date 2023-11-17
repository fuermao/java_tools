package com.fuermao.tools.constant;

import com.fuermao.tools.exception.SexEnumException;

public enum Sex {
	WOMAN("女性", "女", 0),
	MAN("男性", "男", 1);

	private String display;

	private String shortDisplay;

	private int index;

	Sex(String display, String shortDisplay, int index) {
		this.display = display;
		this.shortDisplay = shortDisplay;
		this.index = index;
	}

	/**
	 * 获取性别的显示名称
	 *
	 * @return String 性别名称
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * 设置性别的显示名称
	 *
	 * @param display String 展示名称
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * 获取性别的索引
	 *
	 * @return int 对应性别信息的索引
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 设置性别的索引
	 *
	 * @param index int 索引值
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 获取性别的简短名称
	 *
	 * @return String 性别简称
	 */
	public String getShortDisplay() {
		return shortDisplay;
	}

	/**
	 * 设置性别的简称
	 *
	 * @param shortDisplay String 设置性别的简称
	 */
	public void setShortDisplay(String shortDisplay) {
		this.shortDisplay = shortDisplay;
	}

	/**
	 * 根据索引获取性别
	 *
	 * @param index int 常量索引
	 * @return Sex 性别信息
	 */
	public static Sex getSexByIndex(int index) {
		Sex[] sexes = Sex.values();
		if(index <0 || index >= sexes.length){
			String errMsg = String.format("不存在索引为 %d 的性别常量",index);
			throw new SexEnumException(Sex.class,"性别常量",errMsg);
		}
		Sex target = null;
		for (Sex sex : sexes) {
			if (sex.getIndex() == index) {
				target = sex;
				break;
			}
		}
		return target;
	}

	@Override
	public String toString() {
		return "Sex{" +
				"display='" + display + '\'' +
				", shortDisplay='" + shortDisplay + '\'' +
				", index=" + index +
				'}';
	}
}
