package com.fuermao.tools.utils;

import com.fuermao.tools.constant.FileType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>FileTools</h1>
 * <p>文件类工具</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
public class FileTools {


	/**
	 * 创建临时文件名
	 *
	 * @param isTemp boolean 是否是临时文件
	 * @param type FileType 文件类型
	 * @return 文件名
	 */
	public static String createTempFileName(boolean isTemp, FileType type) {
		StringBuilder builder = new StringBuilder();
		if (isTemp) builder.append("temp_");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSSS");
		String formatStr = formatter.format(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));
		builder.append(formatStr).append(".").append(type.getSuffix());
		return builder.toString();
	}
}
