package com.spring.test.manager;

import com.spring.test.domain.UserReq;
import com.spring.test.domain.UserRes;
import com.spring.test.exception.ServiceException;

import java.util.List;

public interface UserManager {
   List<UserRes>  getUserByName (UserReq  req) ;
   UserRes  getupDateUserById (UserReq req);
   UserRes  getDelectUserByAge (UserReq req);
   UserRes  getInsertUser (UserReq req);
   UserRes getUserById(UserReq req);
}