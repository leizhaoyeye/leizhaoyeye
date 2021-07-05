package com.example.zhaolei.util;

/**
 * @Description: 获取泛型类变量
 * @author: jiahao
 * @Date: 2019/8/6 17:25
 */
public interface Base<T> {

    /**
     * @param variable :  变量名称
     * @description 根据泛型类和变量名称获取变量值
     * @author jia hao
     * @Date 2019/8/6 16:51
     */
    String getVariable(T t, String variable);
}
