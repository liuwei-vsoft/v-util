package com.v.soft.util;

import java.util.Map;
import java.util.Set;

/**
 * @author liuWei
 * @desc String工具类
 * @date 2020/9/10 17:06
 */
public class StringUtil {

    /**
     * 将String转换为整形
     * @param inputNumber
     * @return
     */
    public static int parseInt(String inputNumber) {
        if (inputNumber == null) {
            return -1;
        }
        try {
            return Integer.parseInt(inputNumber.trim());
        }
        catch (Exception ex) {
            return -1;
        }
    }

    /**
     * 将String转换为整形
     *
     * @param inputNumber
     * @param defaultNum
     * @return int
     */
    public static int parseInt(String inputNumber, int defaultNum) {
        if (inputNumber == null) {
            return defaultNum;
        }
        try {
            return Integer.parseInt(inputNumber.trim());
        }
        catch (Exception ex) {
            return defaultNum;
        }
    }

    /**
     * map转String
     * @param map
     * @return
     */
    public static String mapToString(Map<String, String> map) {
        String str = "";
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            str += key + ":" + map.get(key) + ",";
        }
        return str.substring(0, str.length() - 1);
    }
}
