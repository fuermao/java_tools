package com.fuermao.tools.utils;

import com.fuermao.tools.utils.mime.LoadMIMEFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <h1>MIMETools</h1>
 * <p>MIME 解析工具</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
public class MIMETools {
	private static final Logger log = LoggerFactory.getLogger(MIMETools.class);

	private static volatile MIMETools instance = null;

	private static final Map<String, Map<String, String>> mimeTypeTable = new HashMap<>();

	/**
	 * 构造函数
	 */
	MIMETools() {
		// 初始化容器
		mimeTypeTable.put("application", new HashMap<>());
		mimeTypeTable.put("audio", new HashMap<>());
		mimeTypeTable.put("font", new HashMap<>());
		mimeTypeTable.put("image", new HashMap<>());
		mimeTypeTable.put("message", new HashMap<>());
		mimeTypeTable.put("model", new HashMap<>());
		mimeTypeTable.put("multipart", new HashMap<>());
		mimeTypeTable.put("text", new HashMap<>());
		mimeTypeTable.put("video", new HashMap<>());
	}

	/**
	 * 获取 MIMETools 单例
	 *
	 * @return MIMETools 单例
	 */
	public static MIMETools getInstance() {
		if (instance == null) {
			synchronized (MIMETools.class) {
				if (instance == null) {
					instance = new MIMETools();
				}
			}
		}
		return instance;
	}

	/**
	 * 初始化 MIME 类型
	 *
	 * @param contentType MIME 类型，如：application，text 等
	 */
	private void init(String contentType) {
		LoadMIMEFile loadMIMEFile = new LoadMIMEFile(contentType);
		try {
			loadMIMEFile.load(mimeTypeTable.get(contentType));
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
		         IllegalAccessException | IOException e) {
			LogToLogger.throwableToLogger(e, log);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解析 MIME 类型
	 *
	 * @param contentTypeStr MIME 类型字符串，如：application/json
	 * @return String 返回 MIME 类型对应的文件后缀
	 */
	public String parseMIME(String contentTypeStr) {
		String[] split = Objects.requireNonNull(contentTypeStr, "contentTypeStr 不能为空或 null")
				.toLowerCase().split("/");
		if (!mimeTypeTable.containsKey(split[0])) {
			throw new IllegalArgumentException(contentTypeStr + "是不支持的 MIME 类型！");
		}
		if (mimeTypeTable.get(split[0]).isEmpty()) {
			init(split[0]);
		}
		return mimeTypeTable.get(split[0]).get(contentTypeStr.toLowerCase());
	}
}