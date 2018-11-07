package com.spring.test.service;

import com.baomidou.mybatisplus.service.IService;
import com.spring.test.dm.SuccessKilled;
import com.spring.test.dm.SuccesskilledReq;

public interface SuccesskillService  extends IService<SuccessKilled> {
    SuccessKilled insertSuccesskilled (SuccesskilledReq req);
    SuccessKilled selectById(Long id);
}
