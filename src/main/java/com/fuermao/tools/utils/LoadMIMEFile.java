package com.fuermao.tools.utils;

import com.fuermao.tools.utils.mime.MIME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;

/**
 * <h1>LoadMIMEFiles</h1>
 * <p>读取 MIME 文件</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
public class LoadMIMEFile {
	private static final Logger log = LoggerFactory.getLogger(LoadMIMEFile.class);

	private String mimeType;

	/**
	 * 构造器
	 */
	LoadMIMEFile() {

	}

	/**
	 * 构造器
	 *
	 * @param mimeType String mime 类型，比如；application、audio 等等。
	 */
	public LoadMIMEFile(String mimeType) {
		this();
		setMimeType(mimeType);
	}

	/**
	 * 加载 MIME 文件
	 *
	 * @param map Map<String, String>       文件名与文件后缀的映射
	 * @throws ClassNotFoundException       ClassNotFoundException
	 * @throws NoSuchMethodException        NoSuchMethodException
	 * @throws InvocationTargetException    InvocationTargetException
	 * @throws InstantiationException       InstantiationException
	 * @throws IllegalAccessException       IllegalAccessException
	 * @throws IOException                  IOException
	 */
	public void load(Map<String, String> map) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
		String mimeClassName = getMIMEClassName();
		Class<?> mimeClass = Class.forName(mimeClassName);
		// 获取无参构造器
		Constructor<?> constructor = mimeClass.getConstructor();
		constructor.setAccessible(true);
		MIME instance = (MIME) constructor.newInstance();
		instance.loadFile(map);
	}

	/**
	 * 获取 MIME 类名
	 *
	 * @return String MIME 类名
	 */
	private String getMIMEClassName() {
		String packageName = this.getClass().getPackage().getName() + "." + "mime";
		char c = mimeType.charAt(0);
		String className = mimeType.replaceFirst(Character.toString(c), Character.toString(Character.toUpperCase(c)));
		return packageName + "." + className;
	}

	/**
	 * 获取 MIME 类型
	 *
	 * @return String MIME 类型
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * 设置 MIME 类型
	 *
	 * @param mimeType String MIME 类型
	 */
	public void setMimeType(String mimeType) {
		// 转换成小写
		this.mimeType = Objects.requireNonNull(mimeType.toLowerCase(), "mimeType 不能为空");
	}
}
