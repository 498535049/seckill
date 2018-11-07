import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.spring.test.SMS.IndustrySMS;
import com.spring.test.domain.UserReq;
import com.spring.test.domain.UserRes;
import com.spring.test.manager.UserManager;
import com.spring.test.redis.JedisClient;
import com.spring.test.redis.RedisUtils;
import com.spring.test.Email.Send;
import com.spring.test.Email.SendEmail;
import com.spring.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestUser {
    @Autowired
    private UserManager userManager;
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private Send send;

    @Test
    public void test() {
        UserReq req = new UserReq();
        req.setName("Tom");
        List<UserRes> userByName = userManager.getUserByName(req);
        String s = JSON.toJSONString(userByName);

        String a = new String();
    }

    @Test
    public void testUpDate() {
        UserReq req = new UserReq();
        req.setType(4);
        req.setAge(1);
        UserRes userupDateById = userManager.getupDateUserById(req);
        String a = new String();

    }

    @Test
    public void testDelect() {
        UserReq req = new UserReq();
        req.setType(3);
        UserRes userDelectByAge = userManager.getDelectUserByAge(req);
        String a = new String();
    }

    @Test
    public void testInsert() {
        Date day = new Date();
        UserReq req = new UserReq();
        req.setId(1090L);
        req.setName("tt");
        req.setAge(5);
        req.setCtime(day);
        req.setType(6);
        UserRes userRes = userManager.getInsertUser(req);
        String a = new String();
    }

    @Test
    public void testseid() {
        UserReq req = new UserReq();
        req.setId(1037895181922697218l);
        UserRes userRes = userManager.getUserById(req);
        String a = new String();
    }


    @Test
    public void testRedis() {
        Object obj = jedisClient.get(JSON.toJSONString(1));
        if (null == obj) {
            //从数据库查
            UserReq req = new UserReq();
            req.setId(1L);
            UserRes userById = userManager.getUserById(req);
            jedisClient.set(JSON.toJSONString(1), JSON.toJSONString(userById));
        }
        System.out.print(obj);
    }

    @Test
    public void testRedisDelect() {
        Object obj = jedisClient.get("b");
        if (null == obj) {
            UserReq req = new UserReq();
            req.setAge(11);
            UserRes delectByAge = userManager.getDelectUserByAge(req);
        }
        jedisClient.del("b");
        UserReq req = new UserReq();
        req.setType(5);
        UserRes delectByAge = userManager.getDelectUserByAge(req);
    }

    @Test
    public void testRedisRt() {
        Object obj = redisUtils.get("cc");
        if (null == obj) {
            UserReq req = new UserReq();
            req.setId(1L);
            UserRes userRes = userManager.getUserById(req);
            redisUtils.set("cc", JSON.toJSONString(userRes), 10L);
        }
    }

  /*  @Test
    public void emalTest() throws GeneralSecurityException {
        redisUtils.set("email", JSON.toJSONString(SendEmail.send()),100L);
        send.a();
        *//*Scanner input=new Scanner(System.in);

        EmailDetail a = new EmailDetail();
        System.out.println("请输入验证码：");
        String yzm= input.next();
        if (yzm.equals(a.getContent())){
            System.out.println("成功");
        }
        System.out.println("失败");*//*
    }*/
//    @Test
//    public  static void  main(String[] args){
//        IndustrySMS.execute();
//    }


}