package com.piesat.user.service.usercenter;

import com.piesat.user.mapper.usercenter.UserInfoCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaoxiaojun on 2018/04/30.
 */
@Service
@Transactional
public class UserInfoCountService {

    @Autowired
    private UserInfoCountMapper userInfoCountMapper;

    /**
     * 查询用户地块总数
     *
     * @param userId
     * @return
     */
    public Integer queryUserLandCount(String userId){

        return userInfoCountMapper.queryUserLandCount(userId);
    }

    /**
     * 查询用户地块总面积
     *
     * @param userId
     * @return
     */
    public Double queryUserInfoCountAreaSum(String userId){

        return userInfoCountMapper.queryUserInfoCountAreaSum(userId);
    }

    /**
     * 查询用户消息总数
     *
     * @param userId
     * @return
     */
    public Integer queryUserInfoCountMessageSum(String userId){

        return userInfoCountMapper.queryUserInfoCountMessageSum(userId);
    }

    /**
     * 查询用户服务期限
     *
     * @param userId
     * @return
     */
    public String queryUserInfoCountServe(String userId){

        return userInfoCountMapper.queryUserInfoCountServe(userId);
    }


}
