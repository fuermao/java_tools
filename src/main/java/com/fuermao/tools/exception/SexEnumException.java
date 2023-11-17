package com.fuermao.tools.exception;

public class SexEnumException extends EnumConstantNotPresentException{

	private String msg;

	/**
	 * 为指定的常量构造一个 SexEnumException。
	 *
	 * @param enumType      缺失的枚举常量的类型
	 * @param constantName  缺失的枚举常量的名称
	 */
	public SexEnumException(Class<? extends Enum> enumType, String constantName) {
		super(enumType, constantName);
	}

	/**
	 * 为指定的常量构造一个 SexEnumException。
	 * @param enumType          缺失的枚举常量的类型
	 * @param constantName      缺失的枚举常量的名称
	 * @param msg               异常信息
	 */
	public SexEnumException(Class<? extends Enum> enumType, String constantName, String msg) {
		super(enumType, constantName);
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return String.format("%s：%s",super.constantName(),msg);
	}
}
