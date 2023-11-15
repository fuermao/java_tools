package com.fuermao.tools.constant;

import com.fuermao.tools.exception.AgeSegmentationEnumException;

/**
 * 年龄分段
 */
public enum AgeSegmentation {

	INFANT("婴幼儿", 0, 6, 0),
	CHILDREN("少年", 7, 12, 1),
	TEENAGERS("青少年", 13, 17, 2),
	YOUTHS("青年", 18, 45, 3),
	MIDDLE_AGED("中年人", 46, 69, 4),
	AGED("老年人", 70, 120, 5);

	/**
	 * 显示名称
	 */
	private String displayName;

	/**
	 * 最小年龄
	 */
	private int minAge;

	/**
	 * 最大年龄
	 */
	private int maxAge;

	/**
	 * 年龄段索引值
	 */
	private int index;

	/**
	 * 年龄分段枚举类
	 *
	 * @param displayName String  显示名称
	 * @param minAge      int     当前年龄段最小年龄
	 * @param maxAge      int     当前年龄段最大年龄
	 * @param index       int     当前年龄段索引值
	 */
	AgeSegmentation(String displayName, int minAge, int maxAge, int index) {
		setDisplayName(displayName);
		setMinAge(minAge);
		setMaxAge(maxAge);
		setIndex(index);
	}

	/**
	 * 获取显示名称
	 *
	 * @return String 显示名称
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 设置显示名称
	 *
	 * @param displayName String 设置显示名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 获取当前年龄段最小年龄
	 *
	 * @return int 返回当前年龄段最小年龄
	 */
	public int getMinAge() {
		return minAge;
	}

	/**
	 * 设置当前年龄段最小年龄
	 *
	 * @param minAge int 设置当前年龄段最小年龄
	 */
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	/**
	 * 获取当前年龄段最大年龄
	 *
	 * @return int 获取当前年龄段最大年龄
	 */
	public int getMaxAge() {
		return maxAge;
	}

	/**
	 * 设置当前年龄段最大年龄
	 *
	 * @param maxAge int 设置当前年龄段最大年龄
	 */
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * 获取当前年龄段索引值
	 *
	 * @return int 当前年龄段索引值
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 设置当前年龄段索引值
	 *
	 * @param index int 设置当前年龄段索引值
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 获取整个分段的最大值
	 *
	 * @return int 允许的年龄最大值
	 */
	public static int getSegmentationAgeMax() {
		return AGED.maxAge;
	}

	/**
	 * 获取整个分段的最小值
	 *
	 * @return int 允许年龄的最小值
	 */
	public static int getSegmentationAgeMin() {
		return INFANT.minAge;
	}

	/**
	 * 根据索引值获取年龄分段
	 *
	 * @param index int 年龄段索引值
	 * @return AgeSegmentation 枚举类
	 * @throws AgeSegmentationEnumException 枚举常量不存在异常
	 */
	public static AgeSegmentation getAgeSegmentationByIndex(int index) throws AgeSegmentationEnumException {
		AgeSegmentation[] ageSegmentations = values();
		for (AgeSegmentation ageSegmentation : ageSegmentations) {
			if (index == ageSegmentation.getIndex()) {
				return ageSegmentation;
			}
		}
		String formatStr = String.format("不存在索引值为 %d 的年龄段枚举常量！%n", index);
		throw new AgeSegmentationEnumException(AgeSegmentation.class, "年龄分段异常", formatStr);
	}

	/**
	 * 根据年龄判断年龄分段
	 * @param age int 输入需要判断年龄分段的数字
	 * @return AgeSegmentation 年龄分段信息
	 */
	public static AgeSegmentation judgeAgeSegmentation(int age) {
		AgeSegmentation[] segmentations = AgeSegmentation.values();
		int min = getSegmentationAgeMin();
		int max = getSegmentationAgeMax();
		if(!judgeAgeRange(age)){
			String errorMsg = String.format("传入的年龄参数（%d）超出了年龄的允许范围（%d~%d）！%n", age,min,max);
			throw new AgeSegmentationEnumException(AgeSegmentation.class, "年龄分段异常", errorMsg);
		} else {
			AgeSegmentation result = null;
			for (AgeSegmentation segmentation : segmentations) {
				if (segmentation.minAge <= age && age <= segmentation.maxAge) {
					result = segmentation;
					break;
				}
			}
			return result;
		}
	}

	/**
	 * 判断年龄在最小以及最大年龄区间
	 * @param age int 年龄
	 * @return boolean      true    —— 满足年龄范围
	 *                      false   —— 不满足年龄范围
	 */
	public static boolean judgeAgeRange(int age){
		int min = AgeSegmentation.getSegmentationAgeMin();
		int max = AgeSegmentation.getSegmentationAgeMax();
		return age >= min && age <= max;
	}

	@Override
	public String toString() {
		return "AgeSegmentation{" +
				"displayName='" + displayName + '\'' +
				", minAge=" + minAge +
				", maxAge=" + maxAge +
				", index=" + index +
				'}';
	}
}
