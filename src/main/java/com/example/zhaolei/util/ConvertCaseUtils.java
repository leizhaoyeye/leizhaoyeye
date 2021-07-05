
package com.example.zhaolei.util;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.LinkedList;
import java.util.List;


public class ConvertCaseUtils {


     /**
     * 对象转换（数据模型转换）
     * @param listE   从数据库查回来的全部字段模型
     * @param eClass    响应的模型字节码类型
     * @param <T>       响应数据模型
     * @param <B>       全部数据模型
     * @return          List<T>
     */

    public static<T,B>  List<T> convertDataModel(List<B> listE, Class<T> eClass){
        LinkedList<T> list = new LinkedList<>();
        if (CollectionUtils.isNotEmpty(listE)){
            for (B baseModel : listE) { //这里应该能看到是 泛型 B
                T Vo = null;
                try{
                    Vo = eClass.newInstance();
                    BeanUtils.copyProperties(baseModel, Vo);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                list.add(Vo);
            }
        }
        return list;
    }
}

