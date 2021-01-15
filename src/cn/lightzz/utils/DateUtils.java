package cn.lightzz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LightZZ
 * @date 2021/1/15 11:45
 */
public class DateUtils {
    private DateUtils() {
    }

    /**
     * 把日期转为指定格式的字符串
     *
     * @param date   Date类型对象
     * @param format 日期格式化字符串
     * @return 指定格式的字符串
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 把字符串解析为指定格式的日期
     *
     * @param s      指定日期字符串
     * @param format 日期格式化字符串
     * @return 指定格式的日期
     * @throws ParseException 字符串解析异常
     */
    public static Date stringToDate(String s, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(s);
    }
}
