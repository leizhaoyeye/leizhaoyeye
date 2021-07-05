package com.example.zhaolei.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 结果转换工具类
 *
 * @author LJQ
 * @version V1.0
 * @since 2020/10/26 15:56
 */
public class JsonUtil {

    /**
     * 转化返回数据的String
     *
     * @param jsonString
     * @return
     */
    public static String transResultStr(String jsonString) {
        JSONObject jo = JSONObject.parseObject(jsonString);
        if (0 == jo.getInteger("code")) {
            return jo.getString("data");
        } else {
            return null;
        }
    }

    /**
     * 转化JSONArray类型的返回数据成List
     *
     * @param jsonString
     * @param clazz
     * @return
     */
    public static Object transResultForArray(String jsonString, Class clazz) {
        JSONArray array = new JSONArray();
        JSONObject jo = JSONObject.parseObject(jsonString);
        if (0 == jo.getInteger("code")) {
            array = jo.getJSONArray("data");

        }
        if (array != null) {
            return array.toJavaList(clazz);
        } else {
            return null;
        }
    }
}
