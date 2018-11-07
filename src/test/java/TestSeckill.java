import com.spring.test.LatchTest;
import com.spring.test.activemq.SpringJmsTest;
import com.spring.test.dm.*;
import com.spring.test.domain.ZDozerBeanUtil;
import com.spring.test.service.ConsumerTest;
import com.spring.test.service.ProducerTest;
import com.spring.test.service.SeckillService;
import com.spring.test.service.SuccesskillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestSeckill {
    @Autowired
    private ConsumerTest consumerTest;
    @Autowired
    private SeckillService seckillService;
    @Autowired
    private  SuccesskillService successkillService;
    @Autowired
    private ZDozerBeanUtil zDozerBeanUtil;
    @Autowired
    private ProducerTest producerTest;
@Autowired
private SpringJmsTest springJmsTest;
    @Test
    public  void  a(){
        SeckillReq req = new SeckillReq();
        List<SeckillRes> seckillList = seckillService.getSeckillList(req);
        System.out.println(seckillList.size());
    }

    @Test
    public  void  b(){
        SeckillRes id = seckillService.getById(1000L);
        System.out.println(id);
    }

/*
    @Test
    public   void c(){
        Exposer a = seckillService.exportSeckillUrl(1000L);
        System.out.println(a);
    }
*/


    @Test
    public   void  d(){
        SeckillReq seckillReq = new SeckillReq();
        SeckillRes a = seckillService.reduceNumber(1000l,seckillReq);
        System.out.println(a);
    }


    @Test
     public void  e(){
        short a=1;
        SuccesskilledReq req  = new SuccesskilledReq();
        req.setId(1111L);
        req.setUserPhone(17863062222L);
        req.setState(a);
        SuccessKilled successKilled = new SuccessKilled();
        successkillService.insertSuccesskilled(req);
        System.out.println(req);
    }

    @Test
    public  void  f (){
        Date day = new Date();
        Date endday = new Date(day.getTime()+(long)5*60*60*1000);
        /*SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        df.format(new Date(day.getTime() - (long)2 * 24 * 60 * 60 * 1000));*/
        SeckillReq req =new SeckillReq();
        req.setId(1009L);
        long time = System.currentTimeMillis();
        req.setName("100元抢oppo");
        req.setCreateTime(day);
        req.setEndTime(endday);
        req.setNumber(100);
        seckillService.insertSeckill(req);
    }

    @Test
    public  void  g(){
         SuccessKilled id=  successkillService.selectById(1000L);
        System.out.println(id);
    }


    @Test
    public  void  h(){
        SeckillReq req = new SeckillReq();
        req.setId(1001L);
        SeckillRes start =seckillService.seckillStart(req);
        System.out.println(req);
    }
    @Test
    public  void  l() throws IOException {
//        producerTest.sendMq();
        consumerTest.main();
        String a = new String();
        System.in.read();
    }

@Test
    public  void  i(){
        springJmsTest.run();
}
//    @Test
//    public  void  j(){
//        latchTest.main();
//    }
}
