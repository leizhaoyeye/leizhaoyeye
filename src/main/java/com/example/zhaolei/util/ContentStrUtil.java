package com.example.zhaolei.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ContentStrUtil
 * @Description: 富文本工具类
 * @author: xingliang.hou
 * @date: 2020/3/12 7:47
 * @Copyright: 2019 www.dbappsecurity.com.cn. All rights reserved.
 */
public class ContentStrUtil {

    private static final Pattern IMG_URL_PATTERN = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");
    private static final Pattern IMG_PATTERN = Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>", Pattern.CASE_INSENSITIVE);

    public static List<String> getImageUrlList(String content) {
        List<String> resultList = new ArrayList<>();
        if (StringUtils.isEmpty(content)) {
            return resultList;
        }
        Matcher m_image = IMG_PATTERN.matcher(content);
        while (m_image.find()) {
            // 得到<img />数据
            String img = m_image.group();
            Matcher m = IMG_URL_PATTERN.matcher(img);
            // 匹配<img>中的src数据
            while (m.find()) {
                resultList.add(m.group(1));
            }
        }
        return resultList;
    }

}
