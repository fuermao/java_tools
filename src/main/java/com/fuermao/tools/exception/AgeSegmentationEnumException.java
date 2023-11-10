package com.fuermao.tools.exception;

public class AgeSegmentationEnumException extends EnumConstantNotPresentException{

	private String msg;

	/**
	 * 为指定的常量构造一个 AgeSegmentationEnumException。
	 *
	 * @param enumType     缺失的枚举常量的类型
	 * @param constantName 缺失的枚举常量的名称
	 */
	public AgeSegmentationEnumException(Class<? extends Enum> enumType, String constantName) {
		super(enumType, constantName);
	}

	/**
	 * 为指定的常量构造一个 AgeSegmentationEnumException。
	 * @param enumType          缺失的枚举常量的类型
	 * @param constantName      缺失的枚举常量的名称
	 * @param msg               异常信息
	 */
	public AgeSegmentationEnumException(Class<? extends Enum> enumType,String constantName,String msg){
		this(enumType, constantName);
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return String.format("%s：%s",super.constantName(),msg);
	}
}
