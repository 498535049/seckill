package com.spring.test.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.test.dao.UserMapper;
import com.spring.test.domain.*;
import com.spring.test.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements  UserService{


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
@Resource
private UserMapper  userMapper;


@Resource
private  ZDozerBeanUtil  zDozerBeanUtil;

    @Override
    public List<UserRes> selectUserByName(UserReq req)throws ServiceException{
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.eq("name",req.getName());
        List<User>  aUsers = userMapper.selectList(ew);
        if (aUsers.isEmpty()){
            throw  new  ServiceException(ServiceErrorCodeEnum.Data_Query_Fail);
        }
        List<UserRes> aUserRes =   zDozerBeanUtil.convertList(aUsers,UserRes.class);
        return  aUserRes;
    }

    @Override
    public   UserRes    updateUserById  (UserReq req){
        User  user = zDozerBeanUtil.convert(req,User.class);
        Integer  users=userMapper.update(user,new EntityWrapper<User>().eq("type",req.getType()) );
        UserRes userRes = zDozerBeanUtil.convert(user, UserRes.class);
        return  userRes;
    }

    @Override
    public  UserRes delectUserByAge (UserReq req){
        User user = zDozerBeanUtil.convert(req, User.class);
        Integer users = userMapper.delete(new EntityWrapper<User>().eq("type",req.getType()));
        UserRes userRes = zDozerBeanUtil.convert(users,UserRes.class);
        return  userRes;
    }

    @Override
    public   UserRes insertUser (UserReq req){
        User user = zDozerBeanUtil.convert(req, User.class);
        Integer users = userMapper.insert(user);
        UserRes userRes = zDozerBeanUtil.convert(users,UserRes.class);
        return  userRes;
    }

    @Override
    public  UserRes selectUserById (UserReq req){

        User user = userMapper.selectById(req);
      UserRes userRes =  zDozerBeanUtil.convert(user, UserRes.class);

        return  userRes;
    }

}
