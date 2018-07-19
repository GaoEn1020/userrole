package com.piesat.user.service.userservice;


import com.piesat.user.mapper.usermapper.UserMapper;
import com.piesat.user.pojo.usercenter.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层类
 *
 * @author libaosen
 * @version 1.0
 * @date 2018年4月25日
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 通过用户名查询实体
     *
     * @param userName
     * @return
     */
    public int  findByName(String userName){

        // 调取用户数据访问层
        UserEntity userEntity = userMapper.selectByName(userName);
        if(userEntity != null){
            return 1;
        }
        return -1;

    }

    /**
     * 通过用户名和密码查询实体对象
     *
     * @param userName
     * @param userPassword
     * @return
     */
    public UserEntity findByUsernameAndPassword(String userName,String userPassword){

        // 调用用户数据访问层接口
        return userMapper.login(userName,userPassword);
    }

    /**
     * 通过用户id获取实体对象
     *
     * @param userId
     * @return
     */
    public UserEntity findById(String userId){

        // 调用数据访问层接口
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 通过用户id修改密码
     *
     * @param userId
     * @param newPwd
     * @return
     */
    public int modifyUserPassword(String userId,String newPwd){

        // 调用数据访问层接口
       return userMapper.updatePwdByUserId(userId,newPwd);

    }

    /**
     * 通过手机号查询用户
     *
     * @param userPhone
     * @return
     */
    public UserEntity findByUserPhone(String userPhone) {

        // 调用数据访问层
        return userMapper.selectByUserPhone(userPhone);
    }


    /**
     *
     * @param
     * @return
     */
    public List<String> getUserId(){
        // 调用数据访问层
        List<String> userId = userMapper.getUserId();
        return userId;
    }
}
