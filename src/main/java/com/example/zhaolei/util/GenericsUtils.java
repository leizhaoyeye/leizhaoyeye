package com.example.zhaolei.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Description: 泛型工具类
 * @author: jiahao
 * @Date: 2019/8/6 16:19
 */
public class GenericsUtils<T> implements Base<T> {

    /**
     * @param t        :  泛型类
     * @param variable :  变量名称
     * @description  根据泛型类和变量名称获取变量值
     * @author jia hao
     * @Date 2019/8/6 16:51
     */
    @Override
    public String getVariable(T t, String variable) {

        Class<?> beanClass = t.getClass();
        try {
            // 获取属性值(方法一)
            PropertyDescriptor pd = new PropertyDescriptor(variable, beanClass);
            Method rm = pd.getReadMethod();
            //log.info("对应的值是：  "+rm.invoke(t).toString());
            Object invoke = rm.invoke(t);

            //boolean empty = StringUtils.isNotEmpty(.toString());
            if (null != invoke){
                return invoke.toString();
            }
//            // 获取属性值(方法二)
//            Field filed = t.getClass().getDeclaredField(variable);
//            filed.setAccessible(true);
//            return filed.get(t).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
