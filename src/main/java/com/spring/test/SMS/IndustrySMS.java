package com.spring.test.SMS;
import java.net.URLEncoder;
import com.spring.test.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
@Service("industrySMS")
public class IndustrySMS
{
    @Autowired
    private  static RedisUtils redisUtils;
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String to = "17863051322";

    private static String code = smsCode();
    //  登录验证码：{1}，如非本人操作，请忽略此短信。
    private static String smsContent = "【欧阳科技】登录验证码："+code+"，如非本人操作，请忽略此短信。";

    /**
     * 验证码通知短信
     */
    public static SMSDetail execute()
    {

        SMSDetail smsDetail =new SMSDetail();
        smsDetail.setCode(code);
        smsDetail.setTo(to);
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        return smsDetail;
    }

    //创建验证码
    public static String smsCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.println("验证码："+random);
        return random;

    }


}

