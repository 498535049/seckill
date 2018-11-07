package com.spring.test.Email;

import com.alibaba.fastjson.JSONObject;
import com.spring.test.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service("Send")
public class Send {
    @Autowired
    private  static RedisUtils redisUtils;
    public static void  a(){
        Scanner input=new Scanner(System.in);

        EmailDetail a = new EmailDetail();
        System.out.println("请输入验证码：");
        String yzm= input.next();
        String email = (String) redisUtils.get("email");
//        EmailDetail
        EmailDetail parse = JSONObject.parseObject(email, EmailDetail.class);
        if (yzm.equals(parse.getContent())){
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

}
