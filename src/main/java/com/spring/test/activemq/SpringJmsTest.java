package com.spring.test.activemq;

import com.spring.test.dm.SeckillReq;
import com.spring.test.service.SeckillService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by root on 10/5/15.
 */
@Service("springJmsTest")
public class SpringJmsTest{
    @Resource
    private  SpringConsumer springConsumer;
    @Resource
    private  SpringPublisher springPublisher;
    @Resource
    private SeckillService seckillService;

    public  void run() {
            springPublisher.run();

            springConsumer.receive();
    }
}
