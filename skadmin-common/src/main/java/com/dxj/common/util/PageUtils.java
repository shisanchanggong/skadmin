package com.dxj.common.util;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页工具
 *
 * @author dxj
 * @date 2019-04-10
 */
public class PageUtils extends cn.hutool.core.util.PageUtil {

    /**
     * List 分页
     *
     * @param page
     * @param size
     * @param list
     * @return
     */
    public static List toPage(int page, int size, List list) {
        int fromIndex = page * size;
        int toIndex = page * size + size;

        if (fromIndex > list.size()) {
            return new ArrayList();
        } else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        } else {
            return list.subList(fromIndex, toIndex);
        }
    }

    /**
     * Page 数据处理，预防redis反序列化报错
     *
     * @param page
     * @return
     */
    public static Map<String, Object> toPage(Page page) {
        Map<String, Object> map = new HashMap<>();

        map.put("content", page.getContent());
        map.put("totalElements", page.getTotalElements());

        return map;
    }

    /**
     * @param object
     * @param totalElements
     * @return
     */
    public static Map<String, Object> toPage(Object object, Object totalElements) {
        Map<String, Object> map = new HashMap<>();

        map.put("content", object);
        map.put("totalElements", totalElements);

        return map;
    }

}
