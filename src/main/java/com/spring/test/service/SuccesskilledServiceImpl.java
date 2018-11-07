package com.spring.test.service;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.test.dao.SuccesskillMapper;
import com.spring.test.dm.SuccessKilled;
import com.spring.test.dm.SuccesskilledReq;
import com.spring.test.domain.ZDozerBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("successkilledServiceImpl")
@com.alibaba.dubbo.config.annotation.Service
public class SuccesskilledServiceImpl extends ServiceImpl<SuccesskillMapper, SuccessKilled>implements  SuccesskillService {
    @Resource
    private  SuccesskillMapper successkillMapper;
    @Resource
    private ZDozerBeanUtil  zDozerBeanUtil;
    @Autowired
    private  SeckillServiceImpl seckillService;


    @Override
    public SuccessKilled insertSuccesskilled(SuccesskilledReq req){
        SuccessKilled successKilled =zDozerBeanUtil.convert(req,SuccessKilled.class);
        Integer a = successkillMapper.insert(successKilled);
        return  successKilled;
    }

    @Override
    public   SuccessKilled selectById(Long userid){
        SuccessKilled successKilled =  successkillMapper.selectById(userid);
        return  successKilled;
    }
}
