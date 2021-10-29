package com.v.soft.util;

import java.util.UUID;

/**
 * @author liuWei
 * @desc 主键获取工具类
 * @date 2020/8/20 15:15
 */
public class UUIDUtil {

    /**
     * 获取主键（32位，由数字和字母随机组成）
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        String result = uuid.replaceAll("-","");
        return result;
    }
}
