package com.example.demo.data.statistic.utils;

import java.util.Collection;

/**
 * @author author
 */
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
}
