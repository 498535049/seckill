package com.spring.test.redis;


public interface JedisClient {

    String set(String key, String value);
    String get(String key);
    Boolean exists(String key);
    Long expire(String key, int seconds);
    Long del(String key);

}
