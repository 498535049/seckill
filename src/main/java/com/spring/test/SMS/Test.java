package com.spring.test.SMS;

import com.alibaba.fastjson.JSON;
import com.spring.test.Email.SendEmail;
import com.spring.test.redis.RedisUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        RedisUtils redisUtils = (RedisUtils) context.getBean("redisUtils");
        redisUtils.set("SMS", JSON.toJSONString(IndustrySMS.execute()), 100L);
        // 验证码通知短信接口
        pd.pd();
    }


}
