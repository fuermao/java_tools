package com.fuermao.tools.utils;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 手机邮箱工具类
 */
public class MobileAndEmailTools {
    // 手机号前缀
    private static final String[] MOBILE_PREFIX = {
            "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
            "147", "150", "151", "152", "153", "155", "156", "157", "158", "159",
            "170", "171", "172", "173", "174", "175", "176", "177", "178", "180",
            "181", "182", "183", "184", "185", "186", "187", "188", "189"
    };
    // 邮箱后缀
    private static final String[] EMAIL_SUFFIX = {
            "163.com", "126.com", "qq.com", "sina.com", "gmail.com", "boe.com",
            "yahoo.com", "189.com", "sohu.com", "139.com", "vip.sohu.com"
    };

    private static final String[] CHARS = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    // 随机数生成器
    private static final Random random = new Random();

    /**
     * <p>生成随机手机号</p>
     *
     * @return {@link String} 手机号
     */
    public static String createMobile() {
        StringBuilder mobileSb = new StringBuilder();
        // 添加前缀
        int index = random.nextInt(MOBILE_PREFIX.length);
        mobileSb.append(MOBILE_PREFIX[index]);
        random.ints(8, 0, 10).forEach(mobileSb::append);
        return mobileSb.toString();
    }

    /**
     * <p>生成随机邮箱</p>
     *
     * @return {@link String} 邮箱账号
     */
    public static String createEmail() {
        StringBuilder emailSb = new StringBuilder();
        // 添加前缀
        int prefixStrLen = random.nextInt(10) + 10;
        Stream.generate(() -> {
            int index = random.nextInt(CHARS.length);
            return CHARS[index];
        }).limit(prefixStrLen).forEach(emailSb::append);
        // 添加后缀
        int index = random.nextInt(EMAIL_SUFFIX.length);
        emailSb.append("@").append(EMAIL_SUFFIX[index]);
        return emailSb.toString();
    }
}
