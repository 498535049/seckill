package com.spring.test.service;

import com.baomidou.mybatisplus.service.IService;
import com.spring.test.domain.User;
import com.spring.test.domain.UserReq;
import com.spring.test.domain.UserRes;
import com.spring.test.exception.ServiceException;

import java.util.List;

public interface UserService extends IService<User> {
        List<UserRes>  selectUserByName(UserReq  req)throws ServiceException;;
        UserRes updateUserById (UserReq req);
        UserRes  delectUserByAge (UserReq req);
        UserRes insertUser (UserReq req);
       UserRes selectUserById(UserReq req);

}
