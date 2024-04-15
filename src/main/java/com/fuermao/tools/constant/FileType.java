package com.fuermao.tools.constant;

import java.util.Arrays;
import java.util.Optional;

/**
 * <h1>FileType</h1>
 * <p>用于申明文件的类型</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/14</li>
 * </ul>
 */
public enum FileType {
	// 可执行文件
	SH("sh"),
	EXE("exe"),
	DMG("dmg"),
	// 文本文件
	TXT("txt"),
	PDF("pdf"),
	EPUB("epub"),
	// 图片文件
	PNG("png"),
	BMP("bmp"),
	JPG("jpg"),
	JPEG("jpeg"),
	APNG("apng"),
	AVIF("avif"),
	SVG("svg"),
	WEBP("webp"),
	// 音频文件
	AU("au"),
	WAVE("wave"),
	WAV("wav"),
	MP4("mp4"),
	// Java 文件
	JAVA("java"),
	CLASS("class");
	// 文件后缀
	private String suffix;

	/**
	 * 构造函数
	 *
	 * @param suffix String 文件后缀
	 */
	FileType(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * 获取文件类型
	 *
	 * @param index int 索引值
	 * @return FileType 文件类型
	 */
	public static FileType getFileType(int index) {
		FileType[] fileTypes = FileType.values();
		return fileTypes[index];
	}

	/**
	 * 获取文件类型
	 *
	 * @param suffix String
	 * @return FileType 文件类型
	 */
	public static FileType getFileType(String suffix) {
		FileType[] fileTypes = FileType.values();
		Optional<FileType> optional = Arrays.stream(fileTypes)
				.filter(fileType -> fileType.getSuffix().equalsIgnoreCase(suffix))
				.findFirst();
		return optional.orElse(null);
	}

	/**
	 * 获取文件后缀
	 *
	 * @return 文件后缀
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * 设置文件后缀
	 *
	 * @param suffix 文件后缀
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}