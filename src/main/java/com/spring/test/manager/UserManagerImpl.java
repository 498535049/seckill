package com.spring.test.manager;


import com.spring.test.domain.UserReq;
import com.spring.test.domain.UserRes;
import com.spring.test.exception.ServiceException;
import com.spring.test.service.UserService;
import com.spring.test.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userManagerImpl")
@com.alibaba.dubbo.config.annotation.Service
public class UserManagerImpl  implements  UserManager {


    private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserService userService;

    @Override
    public List<UserRes> getUserByName(UserReq req){
        ArrayList list=new ArrayList();
        try {


            List<UserRes> aUserRes = userService.selectUserByName(req);
            return aUserRes;
        }catch (ServiceException e){
            e.printStackTrace();
            //log.error("userService.selectUserByName request object{},error:{}", JSON.toJSONString(req), ExceptionUtils.getStackTrace(e));
            log.error("error ........");
        }
        return list;
    }
    @Override
    public   UserRes getupDateUserById (UserReq req){
        UserRes aUserRes= userService.updateUserById(req);
        return  aUserRes;
    }

    @Override
    public  UserRes   getDelectUserByAge (UserReq req){
        UserRes aUserRes = userService.delectUserByAge(req);
        return  aUserRes;
    }

    @Override
    public  UserRes getInsertUser (UserReq req){
        UserRes userRes = userService.insertUser(req);
        return  userRes;
    }

    @Override
    public   UserRes  getUserById (UserReq req){
        UserRes aUserRes = userService.selectUserById(req);
        return  aUserRes;
    }
}
