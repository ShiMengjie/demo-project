package com.example.demo.score.exchange.component;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 简易版公用 redis 锁
 */
public class RedisLock {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 尝试获取锁，并至多等待timeout时长
     *
     * @param key     锁的key值
     * @param timeout 尝试获取锁的时间
     */
    public boolean tryLock(String key, String value, Duration timeout) {
        // 尝试10次，尽可能让用户能够抽奖
        long begin = System.currentTimeMillis();
        long timeoutMills = timeout.toMillis();
        // 锁的过期时间5秒
        long EXPIRE = 5000L;
        while (true) {
            if (Objects.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, value, EXPIRE, TimeUnit.MILLISECONDS), true)) {
                return true;
            } else {
                if (System.currentTimeMillis() - begin > timeoutMills) {
                    return false;
                }
                Long existExpire = stringRedisTemplate.getExpire(key);
                if (existExpire == null || existExpire < 0L) {
                    // 前一个线程设置锁后，在设置过期时间之前崩溃了，这里要强行获得锁并设置过期时间，防止死锁
                    stringRedisTemplate.expire(key, EXPIRE, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /**
     * 删除该线程的锁
     */
    public void unLock(String key, String value) {
        // 使用lua脚本进行原子删除操作
        String lua = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(lua, Long.class);
        stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value);
    }

    /**
     * 返回锁的key
     */
    @Deprecated
    public String getLockValue(String key) {
        return key + "-LOCK";
    }

    /**
     * 返回锁的key
     */
    public String getLockValue(String key, String suffix) {
        return key + "-" + suffix;
    }

}