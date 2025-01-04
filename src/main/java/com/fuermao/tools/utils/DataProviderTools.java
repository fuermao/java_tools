package com.fuermao.tools.utils;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1>DataProviderTools</h1>
 * <p>数据提供工具类</p>
 *
 * <ul>
 *  <li>@author：Mr.FuErMao</li>
 *  <li>@date：2024/06/21</li>
 * </ul>
 */
public class DataProviderTools {
    /**
     * 手机号前缀
     */
    private static final String[] MOBILE_PREFIX = {"130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "153", "155", "156", "157", "158", "159", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189"};
    /**
     * 邮箱后缀
     */
    private static final String[] EMAIL_SUFFIX = {"163.com", "126.com", "qq.com", "sina.com", "gmail.com", "boe.com", "yahoo.com", "189.com", "sohu.com", "139.com", "vip.sohu.com"};
    /**
     * 随机字符
     */
    private static final String[] CHARS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private static final String[] SPECIAL_CHARS = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "{", "}"};

    private static final Random random = new Random();

    /**
     * 生成随机手机号
     *
     * @return {@link String} 手机号
     */
    public static String mobile() {
        int index = random.nextInt(MOBILE_PREFIX.length);
        StringBuilder mobile = new StringBuilder(MOBILE_PREFIX[index]);
        IntStream.range(0, 9).limit(8).forEach(mobile::append);
        return mobile.toString();
    }

    /**
     * 生成随机邮箱号
     *
     * @return {@link String} 邮箱号
     */
    public static String email() {
        int length = random.nextInt(20) + 8;
        int index = random.nextInt(EMAIL_SUFFIX.length);
        StringBuilder email = new StringBuilder();
        Stream.generate(() -> CHARS[random.nextInt(CHARS.length)]).limit(length).forEach(email::append);
        return email.append("@").append(EMAIL_SUFFIX[index]).toString();
    }

    /**
     * 生成随机用户名
     *
     * @return {@link String} 用户名
     */
    public static String account() {
        return account(false);
    }

    /**
     * 生成用户名
     *
     * @param isPinYin {@link Boolean} 是否按照拼音生成
     * @return {@link String} 用户名
     */
    public static String account(boolean isPinYin) {
        StringBuilder account = new StringBuilder();
        if (!isPinYin) {
            int length = random.nextInt(10) + 6;
            Stream.generate(() -> CHARS[random.nextInt(CHARS.length)]).limit(length).forEach(account::append);
        } else {
            String name = CreateNameTools.createName();
            String pinYin = PinYinTools.getPinYin(name);
            account.append(pinYin);
        }
        return account.toString();
    }


    /**
     * 生成随机强密码
     *
     * @return {@link String} 密码
     */
    public static String password() {
        return password(null, true);
    }

    /**
     * 生成密码
     *
     * @param len       {@link Integer} 密码长度
     * @param isSpecial {@link Boolean} 是否包含特殊字符
     * @return {@link String} 密码
     */
    public static String password(Integer len, boolean isSpecial) {
        if (len == null) {
            len = random.nextInt(13) + 6;
        } else if (len < 6) {
            len = 6;
        } else {
            len = 18;
        }
        StringBuilder pwdSb = new StringBuilder();
        if (!isSpecial) {
            Stream.generate(() -> CHARS[random.nextInt(CHARS.length)]).limit(len).forEach(pwdSb::append);
        } else {
            Stream.generate(() -> {
                int nextInt = random.nextInt(2);
                if (nextInt == 0) {
                    return CHARS[random.nextInt(CHARS.length)];
                } else {
                    return SPECIAL_CHARS[random.nextInt(SPECIAL_CHARS.length)];
                }
            }).limit(len).forEach(pwdSb::append);
        }
        return pwdSb.toString();
    }
}