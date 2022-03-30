package com.example.demo.score.exchange.utils;


import com.netease.game.academy.common.constant.ICache;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 网易游学RedisKey创建工具
 * @author xxx
 */
public class RedisKeyBuilder {

    private static final String REDIS_KEY_SEPARATOR = ":";

    private static final String MODULE_NAME = "game:academy";

    /**
     * 创建RedisKey
     *
     * @param businessName 业务名 {@link com.netease.game.academy.common.constant.ICache.Business}
     * @param dataName     数据名 {@link com.netease.game.academy.common.constant.ICache.Data}
     * @param params       参数
     */
    public static String buildKey(String businessName, String dataName, Object... params) {
        StringBuilder keyBuilder = new StringBuilder(MODULE_NAME);
        keyBuilder.append(REDIS_KEY_SEPARATOR);
        keyBuilder.append(businessName);
        keyBuilder.append(REDIS_KEY_SEPARATOR);
        keyBuilder.append(dataName);
        if (params != null && params.length > 0) {
            keyBuilder.append(REDIS_KEY_SEPARATOR);
            for (Object param : params) {
                keyBuilder.append(param);
                keyBuilder.append(REDIS_KEY_SEPARATOR);
            }
            keyBuilder.deleteCharAt(keyBuilder.length() - 1);
        }
        return keyBuilder.toString();
    }

    /**
     * 批量创建RedisKey,注意仅适用于该业务下数据参数相同
     *
     * @param businessName 业务名 {@link com.netease.game.academy.common.constant.ICache.Business}
     * @param dataClass    数据类 {@link com.netease.game.academy.common.constant.ICache.Data}
     * @param params       参数
     */
    public static Set<String> buildKeys(String businessName, Class<?> dataClass, Object... params) {
        Set<String> keySet = new HashSet<>();
        Class enclosingClass = dataClass.getEnclosingClass();
        if (!enclosingClass.equals(ICache.Data.class)) {
            return null;
        }
        Field[] fields = dataClass.getFields();
        for (Field field : fields) {
            try {
                String key = buildKey(businessName, field.get(dataClass).toString(), params);
                keySet.add(key);
            } catch (IllegalAccessException e) {
                return null;
            }
        }
        return keySet;
    }

}
