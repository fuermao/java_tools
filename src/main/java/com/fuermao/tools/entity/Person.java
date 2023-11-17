package com.fuermao.tools.entity;

import com.fuermao.tools.constant.AgeSegmentation;
import com.fuermao.tools.constant.Sex;
import com.fuermao.tools.utils.CreateNameTools;

import java.util.Random;

public class Person implements Cloneable {

	private final Random random;

	/**
	 * 名字
	 */
	private String name = null;

	/**
	 * 年龄
	 */
	private int age = - 1;

	/**
	 * 年龄分段
	 */
	private AgeSegmentation segmentation;

	private Sex sex;

	{
		random = new Random();
	}

	/**
	 * 无参构造器
	 */
	public Person() {
		// 随机生成姓名以及年龄
		setName();
		setAge();
		setSex();
	}

	public Person(String name, int age) {
		setName(name);
		setAge(age);
		// 随机生成性别
		setSex();
	}

	public Person(String name, int age, int sexIndex) {
		this.name = name;
		this.age = age;
		this.setSex(sexIndex);
	}

	/**
	 * 创建名字
	 *
	 * @param name String 人物名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 生成随机名字
	 */
	public void setName() {
		// 保证名字的长度在2-3个字
		int nameLen = random.nextInt(2) + 2;
		// 根据长度生成随机名字
		String string = CreateNameTools.createName(nameLen);
		// 给 name 属性赋值
		setName(string);
	}

	/**
	 * 设置年龄分段
	 *
	 * @param segmentation AgeSegmentation 年龄分段信息
	 */
	private void setSegmentation(AgeSegmentation segmentation) {
		this.segmentation = segmentation;
	}

	/**
	 * 根据年龄设置年龄分段信息
	 *
	 * @param age int 年龄
	 */
	private void setSegmentation(int age) {
		AgeSegmentation segmentation = AgeSegmentation.judgeAgeSegmentation(age);
		setSegmentation(segmentation);
	}

	/**
	 * 设置人物的年龄
	 *
	 * @param age int 年龄
	 */
	public void setAge(int age) {
		setSegmentation(age);
		// 设置年龄
		this.age = age;
	}

	/**
	 * 给人物设置随机年龄
	 */
	public void setAge() {
		int min, max, result;
		// 获取允许的最大年龄以及最小年龄
		min = AgeSegmentation.getSegmentationAgeMin();
		max = AgeSegmentation.getSegmentationAgeMax();
		// 计算最大年龄与最小年龄的差值
		result = max - min + 1;
		// 生成随机年龄
		int age = random.nextInt(result) + min;
		setAge(age);
	}

	/**
	 * 随机生成性别
	 */
	public void setSex() {
		int index = random.nextInt((Sex.values().length));
		setSex(index);
	}

	/**
	 * 根据性别的索引设置性别
	 *
	 * @param sexIndex int 性别索引
	 */
	public void setSex(int sexIndex) {
		this.sex = Sex.getSexByIndex(sexIndex);
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * 获取人物姓名
	 *
	 * @return String 人物姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取人物年龄
	 *
	 * @return int 人物年龄
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 获取人物年龄分段信息
	 *
	 * @return AgeSegmentation 年龄分段信息
	 */
	public AgeSegmentation getSegmentation() {
		return segmentation;
	}

	public Sex getSex() {
		return sex;
	}

	/**
	 * 返回对象信息
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", segmentation=" + segmentation +
				", sex=" + sex +
				'}';
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
