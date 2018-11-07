package com.spring.test.Email;

import com.alibaba.fastjson.JSON;
import com.spring.test.redis.RedisUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class main {


    public static void main(String[] args) throws GeneralSecurityException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        RedisUtils redisUtils = (RedisUtils) context.getBean("redisUtils");
        redisUtils.set("email", JSON.toJSONString(SendEmail.send()), 100L);
        Send.a();
        System.in.read();
    }
}
