package com.example.zhaolei.util;

import java.util.List;

/**
 * @program: YeeGuideServer
 * @description: list对象转二维数组 工具类
 * @author: jiahao
 * @create: 2019-08-06 16:54
 **/
public class EntityToArrayUtil {

    /**
     * list对象转二维数组
     *
     * @param data
     * @param variable
     * @return
     */
    public static <T> Object[][] toArray(List<T> data, String[] variable) {
        com.example.zhaolei.util.GenericsUtils genericsUtils= new GenericsUtils();
        //动态分配一个二维数组的
        Object[][] obj = new Object[data.size()][variable.length];
        for (int i = 0; i < data.size(); i++) {
            final T t = data.get(i);
            for (int j = 0; j < variable.length; j++) {
                obj[i][j] = genericsUtils.getVariable(t, variable[j]);
            }
        }
        return obj;
    }
}
