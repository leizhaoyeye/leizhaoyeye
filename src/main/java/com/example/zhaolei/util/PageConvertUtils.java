package com.example.zhaolei.util;


//import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.CaseFormat;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

/**
 * 分页对象转换
 *
 * @author zyj
 * @create 2018-10-18
 **/
public class PageConvertUtils {

    private static int MAX_PAGE_SIZE = 100;


    /**
     * page 转 pageImpl
     *
     * @param page
     * @param <T>
     * @return
     */
    /*public static <T> PageImpl<T> convertToPageImpl(Page<T> page) {
        Pageable pageable;
        int current = page.getCurrent();
        current = current > 0 ? current - 1 : current;
        if (ParamUtil.notEmpty(page.getOrderByField())) {
            pageable = new PageRequest(current, page.getSize(), new Sort(new Sort.Order(page.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC, page.getOrderByField())));
        } else {
            pageable = new PageRequest(current, page.getSize());
        }
        return new PageImpl<>(page.getRecords(), pageable, page.getTotal());
    }*/

    /**
     * pageable 封装 page
     * <p>
     * 最多只支持100条记录 一次
     *
     * @param pageable
     * @param <T>
     * @return
     */
    /*public static <T> Page<T> buildPage(Pageable pageable) {

        int pageSize = pageable.getPageSize();
        // 最多只支持100条记录 一次
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }

        int pageNumber = pageable.getPageNumber();
        pageNumber++;
        Page<T> page = new Page<>(pageNumber, pageSize);
        if (ParamUtil.notEmpty(pageable.getSort())) {
            Iterator<Sort.Order> iterator = pageable.getSort().iterator();
            if (iterator.hasNext()) {
                Sort.Order order = iterator.next();
                page = new Page<>(pageNumber, pageSize, upperCharToUnderLineLower(order.getProperty()), order.getDirection().name().equalsIgnoreCase("ASC"));
            }
        }
        return page;
    }*/


    /**
     * 字符串大写字母转下划线
     *
     * @param param
     * @return
     */
    private static String upperCharToUnderLineLower(String param) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, param);
    }
}
