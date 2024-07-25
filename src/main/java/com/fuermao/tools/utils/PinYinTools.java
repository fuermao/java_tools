package com.fuermao.tools.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinTools {
    static final HanyuPinyinOutputFormat format;

    static {
        format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    /**
     * <p>将汉字转为拼音</p>
     *
     * @param chinese {@link String} 汉字
     * @return {@link String} 拼音
     */
    public static String getPinYin(String chinese) {
        try {
            return  PinyinHelper.toHanYuPinyinString(chinese, format, "", true);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            return null;
        }
    }
}
