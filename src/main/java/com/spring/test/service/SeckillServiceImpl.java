package com.spring.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.spring.test.dao.SeckillMapper;
import com.spring.test.dao.SuccesskillMapper;
import com.spring.test.dm.*;
import com.spring.test.domain.ZDozerBeanUtil;
import com.spring.test.exception.SeckillException;
import com.spring.test.redis.JedisClient;
import com.spring.test.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.acl.WorldGroupImpl;

import javax.annotation.Resource;
import java.util.*;

@Service("seckillServiceImpl")
@com.alibaba.dubbo.config.annotation.Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements SeckillService {
    @Resource
    private SeckillMapper seckillMapper;
    @Resource
    private ZDozerBeanUtil zDozerBeanUtil;
    @Resource
    private SuccesskillService successkillService;
    @Autowired
    private RedisUtils redisUtils;
    @Resource
    private JedisClient jedisClient;
    @Resource
    private SuccesskillMapper successkillMapper;
    @Resource
    private  ConsumerTest consumerTest;
    @Resource
    private ProducerTest producerTest;
    private final String salt = "shsdssljdd'l.";

    @Override
    public List<SeckillRes> getSeckillList(SeckillReq req) {
        Object obj = jedisClient.get("seckill");
        List<SeckillRes> seckillRes =new List<SeckillRes>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<SeckillRes> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(SeckillRes seckillRes) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends SeckillRes> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends SeckillRes> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public SeckillRes get(int index) {
                return null;
            }

            @Override
            public SeckillRes set(int index, SeckillRes element) {
                return null;
            }

            @Override
            public void add(int index, SeckillRes element) {

            }

            @Override
            public SeckillRes remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<SeckillRes> listIterator() {
                return null;
            }

            @Override
            public ListIterator<SeckillRes> listIterator(int index) {
                return null;
            }

            @Override
            public List<SeckillRes> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        if (obj==null) {
            EntityWrapper<Seckill> ew = new EntityWrapper<Seckill>();
            /*ew.eq("name","1000元秒杀iphone6");*/
            List<Seckill> a = seckillMapper.selectList(ew);
            String ogj=    jedisClient.set("seckill",JSON.toJSONString(a));
            jedisClient.expire("seckill",100);
            JSONArray parse = (JSONArray) JSONObject.parse(ogj);
            List<Seckill> seckills = parse.toJavaList(Seckill.class);
//            Seckill seckill =     JSONObject.toJavaObject(JSONObject.parseObject(ogj),Seckill.class);
            List<SeckillRes> b = zDozerBeanUtil.convertList(seckills, SeckillRes.class);
            return  b;
        }else {
           String json =   jedisClient.get("seckill");
            JSONArray parse = (JSONArray) JSONObject.parse(json);
            List<Seckill> seckills = parse.toJavaList(Seckill.class);
            List<SeckillRes> b = zDozerBeanUtil.convertList(seckills, SeckillRes.class);
            return  b;
        }
    }

    @Override
    public SeckillRes getById(Long id) {
        Seckill a = seckillMapper.selectById(id);
        SeckillRes seckillRes = zDozerBeanUtil.convert(a, SeckillRes.class);
        return seckillRes;
    }

    @Override
    public SeckillRes insertSeckill(SeckillReq req) {
        Seckill seckill = zDozerBeanUtil.convert(req, Seckill.class);
        Integer insert = seckillMapper.insert(seckill);
        SeckillRes seckillRes = new SeckillRes();
        return seckillRes;
    }

//    @Override
//    public SeckillRes exportSeckillUrl( SeckillReq req){
//        SeckillRes seckillRes = getById(req);
//        Long id = zDozerBeanUtil.convert(seckillRes,SeckillRes.class);
//
//        Date startTime = seckillRes.getStartTime();
//        Date endTime = seckillRes.getEndTime();
//
//        Date  nowTime = new Date();
//
//        if (startTime.getTime()>nowTime.getTime()||endTime.getTime()<nowTime.getTime()){
//            return  new Exposer(false,id,nowTime.getTime(),startTime.getTime(),endTime.getTime());
//        }
//
//        String md5 = getMD5(id);
//        return  new Exposer(true,md5,id);
//    }
//    private  String getMD5 (Long id){
//        String base = id + "/" + salt;
//        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
//        return md5;
//    }


    @Override
    @Transactional
    public SeckillRes reduceNumber(Long id, SeckillReq seckillReq)throws SeckillException {
        Seckill seckill = zDozerBeanUtil.convert(seckillReq, Seckill.class);
        SeckillRes getselect = getById(id);
        Integer getnumber = getselect.getNumber();
        if (getnumber <= 0) {
            throw  new  SeckillException("没有库存");
        }
        getnumber--;
        seckill.setId(id);
        seckill.setNumber(getnumber);
        //seckillMapper.updateById(seckill);
        EntityWrapper ew = new EntityWrapper();
        ew.eq("id", id);
        Integer a = seckillMapper.update(seckill, ew);
        SeckillRes seckillRes = new SeckillRes();
        return seckillRes;
    }

/*

    @Override
    @Transactional
    */

    /**
     * 使用注解控制事务方法的优点:
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     *//*

    public SeckillExecution executeSeckill(Long id, Long userPhone, String md5)
            {

//        if (md5 == null || !md5.equals(getMD5(id))) {
//            //秒杀数据被重写了
//            throw new SeckillException("seckill data rewrite");
//        }
        //执行秒杀逻辑:减库存+增加购买明细
        Date nowTime = new Date();

        try {

            //否则更新了库存，秒杀成功,增加明细
            int insertCount = successkillService.insertSuccesskilled();
            //看是否该明细被重复插入，即用户是否重复秒杀
            if (insertCount <= 0) {
                throw new RepeatKillException("seckill repeated");
            } else {

                //减库存,热点商品竞争
                int updateCount = reduceNumber(id,);
                if (updateCount <= 0) {
                    //没有更新库存记录，说明秒杀结束 rollback
                    throw new SeckillCloseException("seckill is closed");
                } else {
                    //秒杀成功,得到成功插入的明细记录,并返回成功秒杀的信息 commit
                    List<Seckill> seckill = getSeckillList();
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }

            }


        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所以编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :" + e.getMessage());
        }

    }


*/
    @Transactional
    @Override
    public SeckillRes seckillStart(SeckillReq req) throws SeckillException {
        SeckillRes seckillRes = new SeckillRes();
        List<SeckillRes> a = getSeckillList(req);
        SeckillRes getOne = getById(req.getId());
        Date startTime = getOne.getStartTime();
        Date endTime = getOne.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() > endTime.getTime() || nowTime.getTime() < startTime.getTime()) {
            throw new  SeckillException("seckill time out ");

        }
        SeckillRes b = reduceNumber(req.getId(), req);
        SuccesskilledReq d = zDozerBeanUtil.convert(req, SuccesskilledReq.class);
        d.setUserPhone(1000013213L);
        d.setState((short)1);
        d.setUserid(IdWorker.getId());
        SuccessKilled c = successkillService.insertSuccesskilled(d);
        return seckillRes;
    }

}
