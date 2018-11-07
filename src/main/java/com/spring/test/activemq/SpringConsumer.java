package com.spring.test.activemq;

import com.spring.test.dm.SeckillReq;
import com.spring.test.service.SeckillService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.TextMessage;

/**
 * Created by root on 10/5/15.
 */
@Service("springConsumer")
public class SpringConsumer {
    @Resource
    private SeckillService seckillService;
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    //接收消息
    public void receive() {
        while (true) {
            try {
                //使用JMSTemplate接收消息
                TextMessage txtmsg = (TextMessage) jmsTemplate.receive();
                if (null != txtmsg) {
                    System.out.println("--- 收到消息内容为: " + txtmsg.getText());
                    SeckillReq req =new SeckillReq();
                    req.setId(1000l);
                    seckillService.seckillStart(req);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
