package com.spring.test.activemq;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by root on 10/5/15.
 */
@Service("springProducer")
public class SpringPublisher {
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    public void run() throws JmsException {
        jmsTemplate.send(new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                    Message message = session.createTextMessage("hello jms");
                    return message;
            }
        });
    }
}
