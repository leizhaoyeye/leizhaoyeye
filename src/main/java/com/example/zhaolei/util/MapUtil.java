package com.example.zhaolei.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by hasee on 2017/6/15.
 */
public class MapUtil {
    public static Map unionMap(Map source,Map target){
        if(Objects.isNull(source)||Objects.isNull(target)){
            return null;
        }
        Set targetKeys = target.keySet();
        for(Object key : targetKeys){
            source.put(key,target.get(key));
        }
        return source;
    }

    public static Map asMap(Object ... param){
        if(Objects.isNull(param)||(param.length%2!=0)){
            return null;
        }
        Map result = new HashMap();
        for(int i=0;i<param.length;i+=2){
            result.put(param[i],param[i+1]);
        }
        return  result;
    }

    public static String getString(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }
        return null;
    }


    public static String getString(Map map, Object key, String defaultValue) {
        String answer = getString(map, key);
        if (answer == null) {
            answer = defaultValue;
        }

        return answer;
    }

}
