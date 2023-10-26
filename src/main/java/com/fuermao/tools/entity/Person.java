package com.fuermao.tools.entity;

import com.fuermao.tools.utils.CreateNameTools;

import java.util.Random;

public class Person implements Cloneable {

	private final Random random;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 年龄
	 */
	private int age;

	/**
	 * 年龄分段
	 */
	private AgeSegmentation segmentation;

	/**
	 * 无参构造
	 */
	public Person() {
		random = new Random();
		// 随机生成名字
		this.setName();
		this.setAge();
	}

	/**
	 * 有参构造方法
	 *
	 * @param name String 名字
	 * @param age  int 年龄
	 */
	public Person(String name, int age) {
		this();
		this.setName(name);
		this.setAge(age);
	}

	/**
	 * 设置指定年龄
	 *
	 * @param age int 年龄
	 */
	public void setAge(int age) {
		// 根据年龄获取年龄分段信息
		setSegmentation(AgeSegmentation.judgeAgeSegmentation(age));
		this.age = age;
	}

	/**
	 * 设置随机年龄
	 */
	public void setAge() {
		AgeSegmentation[] segmentations = AgeSegmentation.values();
		// 随机生成年龄段信息
		int index = random.nextInt(segmentations.length);
		// 获取随机生成的年龄段
		AgeSegmentation ageSegmentation = AgeSegmentation.getAgeSegmentationByIndex(index);
		int res = ageSegmentation.getMaxAge() - ageSegmentation.getMinAge();
		int age = random.nextInt(res) + ageSegmentation.getMinAge();
		// 设置年龄分段信息
		setAge(age);
	}

	/**
	 * 设置年龄分段信息
	 *
	 * @param segmentation 年龄分段枚举信息
	 */
	public void setSegmentation(AgeSegmentation segmentation) {
		this.segmentation = segmentation;
	}

	/**
	 * 设置名字
	 *
	 * @param name String 设置名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 生成随机名字
	 */
	public void setName() {
		setName(CreateNameTools.createName());
	}

	/**
	 * 获取名字
	 *
	 * @return String 名字
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取年龄信息
	 *
	 * @return int 返回年龄
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 获取年龄分段信息
	 *
	 * @return AgeSegmentation 年龄分段信息
	 */
	public AgeSegmentation getSegmentation() {
		return segmentation;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", segmentation=" + segmentation +
				'}';
	}

	@Override
	public Person clone() {
		try {
			// 浅拷贝
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
