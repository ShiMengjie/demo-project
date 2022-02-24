package com.example.demo.data.statistic.util;

import java.util.*;

public class CollectionUtil {

    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 空:true, 非空:false
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断集合是否非空
     *
     * @param collection 集合
     * @return 空:false, 非空:true
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断 map 是否为空
     *
     * @param map MAP
     * @return 空:true, 非空:false
     */
    public static boolean isMapEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 从 map 中取出 pageSize 个数据，移除已取出的数据
     */
    public static <K, V> Map<K, V> removePageMap(Map<K, V> map, int pageSize) {
        int cur = 0;

        Map<K, V> result = new HashMap<>(pageSize);

        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext() && cur < pageSize) {
            Map.Entry<K, V> entry = iterator.next();
            result.put(entry.getKey(), entry.getValue());
            iterator.remove();
            cur++;
        }
        return result;
    }

    /**
     * 分页取出列表，如果超出范围，返回 null
     *
     * @param pageNum  页码，从 1 开始
     * @param pageSize 每页大小
     */
    public static <T> List<T> pageList(List<T> list, int pageNum, int pageSize) {
        int size = list.size(), start = (pageNum - 1) * pageSize, end = pageNum * pageSize;
        if (start > size) {
            return null;
        } else if (end > size) {
            return list.subList(start, size);
        } else {
            return list.subList(start, end);
        }
    }

}
