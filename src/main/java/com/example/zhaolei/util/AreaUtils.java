package com.example.zhaolei.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: Luoqy
 * @date: 2020/2/15 11:44
 */
public class AreaUtils {


    /**
     * 组装省市区县地址信息，中间用逗号分隔
     *
     * @param country
     * @param province
     * @param city
     * @param district
     * @return
     */
    public static String computeAreaInfo(String country, String province, String city, String district) {
        if (StringUtils.isBlank(country)) {
            // 默认中国
            country = "1";
        }

        StringBuffer areaInfo = new StringBuffer(country);

        if (StringUtils.isNotBlank(province)) {
            areaInfo.append(",").append(province);
        }

        if (StringUtils.isNotBlank(city)) {
            areaInfo.append(",").append(city);
        }

        if (StringUtils.isNotBlank(district)) {
            areaInfo.append(",").append(district);
        }
        return areaInfo.toString();
    }
}
