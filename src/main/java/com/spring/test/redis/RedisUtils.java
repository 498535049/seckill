/************************************************************************************
 *
 * 有贝科技                                                                      
 *
 * 项目名称：风控v3.0                                                          
 * 版权说明：本软件属有贝科技所有，在未获得有贝科技正式授权情况下，任何企业和   
 *			 个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的    
 *			 内容。                            
 ************************************************************************************/
package com.spring.test.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author anfengjiao
 * @version 2.0
 * @Package com.uubee.mngserviceisu.core.utils
 * @Description: redis 工具类
 * @date 2018/1/19 下午2:17
 */
@Component("redisUtils")
public  class RedisUtils {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public static RedisUtils redisUtils;

    @PostConstruct
    public void init() {
        redisUtils = this;
        redisUtils.redisTemplate = this.redisTemplate;
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return redisUtils.redisTemplate.opsForValue().get(key);
    }

    /**
     * 永久写入缓存 慎用
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        redisUtils.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 永久写入缓存 慎用
     *
     * @param key
     * @param value
     */
    public static void set(String key, Long value) {
        redisUtils.redisTemplate.opsForValue().set(key, value.toString());
    }

    /**
     * 写入缓存 过期时间 秒
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public static void set(String key, Object value, long expireTime) {
        redisUtils.redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 自增
     *
     * @param key
     * @param delta
     * @return
     */
    public static long increment(String key, long delta) {
        return redisUtils.redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 写入map缓存 永久
     *
     * @param key
     * @param map
     * @param <T>
     */
    public static <T> void setMap(String key, Map<String, T> map) {
        redisUtils.redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 写入map类型缓存 过期时间秒
     *
     * @param key
     * @param map
     * @param expireTime
     * @param <T>
     */
    public static <T> void setMap(String key, Map<String, T> map, long expireTime) {
        redisUtils.redisTemplate.opsForHash().putAll(key, map);
        redisUtils.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    /**
     * map中增加
     *
     * @param key
     * @param field
     * @param value
     * @param <T>
     */
    public static <T> void addMap(String key, String field, T value) {
        redisUtils.redisTemplate.opsForHash().put(key, field, value);
    }

}

