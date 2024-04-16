package com.fuermao.tools.utils.mime;

import com.fuermao.tools.constant.FileType;

import java.io.*;
import java.nio.file.Paths;
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
	/**
	 * 获取文件
	 * @return File
	 */
	default File getCSVFile(){
		String classPathStr = Objects.requireNonNull(MIME.class.getResource("/")).getFile();
		File classPathFile = new File(classPathStr).getAbsoluteFile();
		String mimeNameStr = this.getClass().getSimpleName().toLowerCase()+"."+ FileType.CSV.getSuffix();
		return Paths.get(classPathFile.toString(), "mime", mimeNameStr).toFile();
	}

	/**
	 * 加载文件
	 * @param map map
	 * @throws IOException IOException
	 */
	default void loadFile(Map<String, String> map) throws IOException {
		File file = getCSVFile();
		if(!file.exists() || !file.isFile()){
			throw new FileNotFoundException("文件"+file.getName()+"不存在！");
		}
		try(LineNumberReader reader = new LineNumberReader(new FileReader(file))) {
			reader.lines().skip(1).forEach(line -> {
				String[] split = line.split(",");
				if (split.length >= 2){
					map.put(split[1], split[0]);
				}
			});
		} catch (IOException exception){
			throw new IOException("文件"+file.getName()+"读取失败！");
		}
	}
}
