package com.example.zhaolei.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 图片名片生成规则
     * <p>
     * 随机数：(int)((Math.random()*9+1)*100000)
     */
    public static String generateIdForImage() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + String.valueOf((long) ((Math.random() * 9 + 1) * 100000));
    }

    public static String generateAccess() {
        String access = UUID.randomUUID().toString().replace("-", "");
        access = access.substring(0, 8);
        return access;
    }
}
