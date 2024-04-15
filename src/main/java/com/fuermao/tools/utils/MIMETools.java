package com.fuermao.tools.utils;

import com.fuermao.tools.constant.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;

/**
 * <h1>MIMETools</h1>
 * <p>MIME 对应文件类型</p>
 *
 * <ul>
 *  <li>author：Mr.FuErMao</li>
 *  <li>date：2024/04/15</li>
 * </ul>
 */
public class MIMETools {
    private static final Logger log = LoggerFactory.getLogger(MIMETools.class);
    
    private static volatile MIMETools instance = null;
    
    private static final String[] mimeTypeArr = {
            "application/",
            "audio/",
            "font/",
            "image/",
            "message/",
            "model/",
            "multipart/",
            "text/",
            "video/"
    };
    
    private File mimeCSVDirFile;
    
    private Map<String, String> application;
    private Map<String, String> audio;
    private Map<String, String> font;
    private Map<String, String> image;
    private Map<String, String> message;
    private Map<String, String> model;
    private Map<String, String> multipart;
    private Map<String, String> text;
    private Map<String, String> video;
    
    MIMETools() {
        // 初始化容器
        application = new HashMap<>();
        audio = new HashMap<>();
        font = new HashMap<>();
        image = new HashMap<>();
        message = new HashMap<>();
        model = new HashMap<>();
        multipart = new HashMap<>();
        text = new HashMap<>();
        video = new HashMap<>();
        
        // 初始化路径
        String CLASS_PATH_STR = Objects.requireNonNull(MIMETools.class.getResource("/")).getPath();
        File classPathFile = new File(CLASS_PATH_STR).getAbsoluteFile();
        mimeCSVDirFile = new File(classPathFile, "mime");
        log.debug(mimeCSVDirFile.toString());
    }
    
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
    
    private void init(String contentType) {
    
    }
    
    public void parseMIME(String contentTypeStr) {
        contentTypeStr = contentTypeStr.toLowerCase();
        Optional<String> optional = Arrays.stream(mimeTypeArr).filter(contentTypeStr::contains).findAny();
        optional.orElseThrow(() -> new RuntimeException("MIME类型不存在"));
        String[] split = contentTypeStr.split("/");
        // 需要读取的文件
        String contentTypeFileName = split[0] + "." + FileType.CSV.getSuffix();
        switch (split[0]){
            case "application":
                loadMIMEFile(application,contentTypeFileName);
                break;
            case "audio":
                loadMIMEFile(audio,contentTypeFileName);
                break;
            case "font":
                loadMIMEFile(font,contentTypeFileName);
                break;
            case "image":
                loadMIMEFile(image,contentTypeFileName);
                break;
            case "message":
                loadMIMEFile(message,contentTypeFileName);
                break;
        }
    }
    
    private void loadMIMEFile(Map<String,String> map,String contentTypeFileName) throws IOException {
        if(!map.isEmpty()){
            return;
        }
        File mimeFile = new File(mimeCSVDirFile, contentTypeFileName);
        if(!mimeFile.exists()){
            throw new IOException(mimeFile.getName() + "文件不存在！");
        }
        try(LineNumberReader reader = new LineNumberReader(new FileReader(mimeFile))){
            reader.lines().forEach(line->{
                String[] data = line.split(",");
            });
        } catch (IOException e) {
            throw e;
        }
        
    }
}