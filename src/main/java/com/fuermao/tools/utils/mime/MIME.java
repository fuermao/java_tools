package com.fuermao.tools.utils.mime;

import com.fuermao.tools.constant.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;
import java.util.Objects;

/**
 * <h1>MIME</h1>
 * <p>读取指定的文件</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
public interface MIME {

	Logger log = LoggerFactory.getLogger(MIME.class);

	/**
	 * 获取文件
	 *
	 * @return File
	 */
	default String getCSVFile() {
		// 生成需要加载的 CSV 文件名
		String mimeNameStr = this.getClass().getSimpleName().toLowerCase() + "." + FileType.CSV.getSuffix();
		return "mime/" + mimeNameStr;
	}

	/**
	 * 加载文件
	 *
	 * @param map map
	 * @throws IOException IOException
	 */
	default void loadFile(Map<String, String> map) throws IOException {
		String csvFile = getCSVFile();
		log.debug("即将加载的 MIME 文件是：{}", csvFile);
		try (InputStream resourceAsStream = Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(csvFile));
		     LineNumberReader reader = new LineNumberReader(new InputStreamReader(resourceAsStream))){
			// 跳过第一行，再读取 CSV 文件中的每一行。
			reader.lines().skip(1).forEach(line -> {
				String[] split = line.split(",");
				if (split.length >= 2) {
					map.put(split[1], split[0]);
				}
			});
		} catch (NullPointerException | IOException exception) {
			throw new IOException("文件 " + csvFile + " 读取失败！"+exception.getMessage());
		}
	}
}