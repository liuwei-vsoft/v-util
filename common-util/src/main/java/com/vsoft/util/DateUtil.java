package main.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuWei
 * @desc 日期工具类
 * @date 2021/9/23 16:16
 */
public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String FORMAT_1 = "yyyy-MM-dd";
    public static final String FORMAT_2 = "yyyy-MM-dd HH:mm:ss";


    /**
     * 将Date转换为String
     * @param date
     * @param formatStr 转换的格式
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isBlank(formatStr)) {
            return dateToString(date);
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            return format.format(date);
        } catch (Exception e) {
            logger.info("Date转换为String异常", e);
            return "";
        }
    }

    /**
     * 将Date转换为String
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_1);
        return format.format(date);
    }


    /**
     * 将字符串转化为Date类型
     * @param str
     * @return
     */
    public static Date stringToDate(String str)  {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_1);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            logger.info("日期转换异常", e);
        }
        return null;
    }
}
