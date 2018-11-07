package com.spring.test.mq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerClient {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("mq/consumer.xml");
        System.out.println("Consumer Started");
    }
}
