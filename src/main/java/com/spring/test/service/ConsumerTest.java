package com.spring.test.service;

import com.aliyun.openservices.ons.api.*;
import com.spring.test.dm.Mq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("consumerTest")
public class ConsumerTest {
    public  void main() {
        Properties properties = new Properties();
        // 您在控制台创建的 Consumer ID
        properties.put(PropertyKeyConst.ConsumerId, "CID-214214");
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, "LTAIEHwhbVPpTFFs");
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "sIi18usgqaVAa8V9cYtM1i0dBCPHur");
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put(PropertyKeyConst.ONSAddr,
                "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
//         集群订阅方式 (默认)
         properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
        // 广播订阅方式
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.BROADCASTING);
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("121313", "TagA||TagB", new MessageListener() { //订阅多个 Tag
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);

                return Action.CommitMessage;
            }
        });
        //订阅另外一个 Topic
        consumer.subscribe("TopicTestMQ-Other", "*", new MessageListener() { //订阅全部 Tag
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}