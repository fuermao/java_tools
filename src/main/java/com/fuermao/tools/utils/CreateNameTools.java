package com.fuermao.tools.utils;

import java.util.Random;

/**
 * 该类用于生成随机名字以及性别
 *
 * @author fuermao
 */
public class CreateNameTools {

	/**
	 * 姓氏字符串
	 */
	private static final String firstNameStr = "李王张刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕苏卢蒋蔡贾丁魏薛叶间余潘杜戴夏钟汪田任美范方石姚谭痕邹熊金陆郝孔白准康毛邱泰江史预侯邵孟龙万段章钱汤";
	/**
	 * 名字字符串
	 */
	private static final String lastNameStr = "梦琪忆柳之桃慕青问兰尔岚元香初夏沛菌傲珊曼文乐菱痴恨玉惜寒新柔语蓉海安夜涵柏水醉蓝春儿琴从彤晴又碧霜怜紫妙易南莲翠雨烟如萱若寻真晓亦向灵以蕊雁映雪孤笑云凝天冰旋宛绿盼凡菡半雅槐平书风巧代幼友听访凌卉怀靖蕾松枫念薇山觅波静露芷干冷芙蝶白筠芹丹珍谷瑶冬竹幻荷含萍丝秋双依迎梅阳诗飞寄小幕";

	/**
	 * 随机类
	 */
	private static final Random random;

	static {
		random = new Random();
	}

	/**
	 * 静态方法：生成随机名字
	 *
	 * @return String 返回随机生成的名字
	 */
	public static String createName() {
		// 随机生成名字的长度
		int nameLen = random.nextInt(2) + 2;
		return createName(nameLen);
	}

	/**
	 * 静态方法：生成指定长度的名字
	 *
	 * @param length int 名字的长度
	 * @return String 返回随机生成的名字
	 */
	public static String createName(int length) {
		// 创建名字的缓冲区
		StringBuffer nameSB = new StringBuffer();
		// 判断名字长度是否为 0。
		if (length == 0) {
			return nameSB.toString();
		}
		// 随机创建姓的索引
		int firstNameIndex = random.nextInt(firstNameStr.length());
		// 生成的姓氏添加到缓冲区
		nameSB.append(firstNameStr.charAt(firstNameIndex));
		if (length == 1) {
			return nameSB.toString();
		}
		for (int i = 0; i < length - 1; i++) {
			// 创建随机字的索引
			int lastNameIndex = random.nextInt(lastNameStr.length());
			nameSB.append(lastNameStr.charAt(lastNameIndex));
		}
		return nameSB.toString();
	}
}
