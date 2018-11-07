package com.spring.test.SMS;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.spring.test.Email.EmailDetail;
import com.spring.test.domain.UserReq;
import com.spring.test.manager.UserManager;
import com.spring.test.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("pd")
public class pd {
    @Autowired
    private static RedisUtils redisUtils;
    @Autowired
    private  static UserManager userManager;

    public static void pd() {
        Scanner input = new Scanner(System.in);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        UserManager userManager = (UserManager) context.getBean("userManagerImpl");
        SMSDetail a = new SMSDetail();
        System.out.println("请输入验证码：");
        String code = input.next();
        String sms = (String) redisUtils.get("SMS");
        SMSDetail parse = JSONObject.parseObject(sms, SMSDetail.class);
        if (code.equals(parse.getCode())) {
            System.out.println("成功");
            String name = input.next();
            UserReq req = new UserReq();
            req.setId(IdWorker.getId());
            req.setName(name);
            userManager.getInsertUser(req);
        } else {
            System.out.println("失败");
        }
    }
}