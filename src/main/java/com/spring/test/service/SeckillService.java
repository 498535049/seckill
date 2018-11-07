package com.spring.test.service;

import com.baomidou.mybatisplus.service.IService;
import com.spring.test.dm.*;
import com.spring.test.exception.SeckillException;

import java.util.List;

public interface SeckillService extends IService<Seckill> {
    List<SeckillRes> getSeckillList(SeckillReq req);
    SeckillRes getById(Long id);
//    SeckillRes exportSeckillUrl(SeckillReq req);
    SeckillRes  reduceNumber(Long id,SeckillReq req )throws  SeckillException;
    SeckillRes  insertSeckill(SeckillReq req);
//    SeckillExecution executeSeckill(Long id, Long userPhone ,String md5);
    SeckillRes  seckillStart(SeckillReq req) throws SeckillException;
}
