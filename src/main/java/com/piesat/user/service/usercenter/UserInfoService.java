package com.piesat.user.service.usercenter;


import com.piesat.user.mapper.usercenter.UserInfoMapper;
import com.piesat.user.pojo.usercenter.UserCountInfo;
import com.piesat.user.pojo.usercenter.UserInfo;
import com.piesat.user.pojo.usercenter.UserMessage;
import com.piesat.user.pojo.usercenter.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaoxiaojun on 2018/04/23.
 */
@Service
@Transactional
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询个人信息的状态和类型
     *
     * @param userId
     * @return
     */
    public UserInfo findStausAndType(String userId) {
        UserInfo userInfo = userInfoMapper.findStausAndType(userId);
        return userInfo;
    }

    /**
     * 查询个人信息
     *
     * @param userId
     * @return
     */
    public UserInfo queryUserInfo(String userId) {
        UserInfo userInfo = userInfoMapper.queryUserInfo(userId);
        return userInfo;
    }

    /**
     * 该用户是否存在
     *
     * @param userId
     * @return
     */
    public boolean isExist(String userId) {
        UserInfo userInfo = userInfoMapper.queryUserInfo(userId);
        return userInfo != null;
    }

    /**
     * 修改个人信息
     *
     * @param userInfo
     * @return
     */
    public int updateUserInfo(UserInfo userInfo) {
        int num;
        if(userInfoMapper.updateUserInfo(userInfo)){
            num = 1;
        }else{
            num = 0;
        }
        return num;
    }

    /**
     * 查询用户消息
     *
     * @param userId
     * @return
     */
    public List<UserMessage> queryUserMessage(String userId) {
        return userInfoMapper.queryUserMessage(userId);
    }

    /**
     * 查询该消息是否存在
     *
     * @param messageId
     * @return
     */
    public boolean findUserMessageById(String messageId) {
        UserMessage userMessage = userInfoMapper.findUserMessageById(messageId);
        return userMessage != null && userMessage.getMessageCancel() == 1;
    }

    /**
     * 删除个人中心消息
     *
     * @param userId
     * @param messageId
     * @return
     */
    public boolean deleteUserMessage(String userId, String messageId) {
        boolean messageStaus = userInfoMapper.deleteUserMessage(userId,messageId);
        return messageStaus == true;
    }

    /**
     * 修改消息状态
     *
     * @param messageId
     * @return
     */
    public boolean updateUserMessage(String messageId) {
        return userInfoMapper.updateUserMessage(messageId);
    }

    /**
     * 查询所有个人信息
     *
     * @param
     * @return
     */
    public List<UserInfo> queryUserInfoList() {
        List<UserInfo> userInfo = userInfoMapper.queryUserInfoList();
        return userInfo;
    }

    /**
     * 查询气象类第一条消息
     * @return
     */
    public UserMessage findUserMessageContentByZero(String userId) {
       return userInfoMapper.findUserMessageContentByZero(userId);
    }

    /**
     * 查询计划类第一条消息
     *
     * @return
     */
    public UserMessage findUserMessageContentByOne(String userId) {
        return userInfoMapper.findUserMessageContentByOne(userId);
    }

    /**
     * 查询计划类第一条消息
     *
     * @return
     */
    public UserMessage findUserMessageContentByTwo(String userId) {
        return userInfoMapper.findUserMessageContentByTwo(userId);
    }

    /**
     * 查询异常类第一条消息
     *
     * @return
     */
    public UserMessage findUserMessageContentByThree(String userId) {
        return userInfoMapper.findUserMessageContentByThree(userId);
    }

    public UserMessage findUserMessageContentByFour(String userId) {
        return userInfoMapper.findUserMessageContentByFour(userId);
    }

    public boolean addUserView(UserView userView) {
        return userInfoMapper.addUserView(userView);
    }

    /**
     * 整理用户的信息
     * @param userId
     * @return
     */
    public List<UserCountInfo> userSumInfo(String userId, String userNameId){
        List<UserCountInfo> userCountInfos=userInfoMapper.userSumInfo(userId,userNameId);
        return userCountInfos;
    }
    /**
     * 根据nameID查询
     * */
    public UserInfo findByNameId(String userNameId){
        UserInfo userInfo=userInfoMapper.findByNameId(userNameId);
        return userInfo;
    }
    public List<UserView> userViewFind(String userId){
        return userInfoMapper.userViewFind(userId);
    }
}
