package com.piesat.user.service.usercenter;


import com.piesat.user.mapper.usercenter.UserInfoContentMapper;
import com.piesat.user.pojo.usercenter.UserInfoContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoContentService {
    @Autowired
    private UserInfoContentMapper userInfoContentMapper;

    public List<UserInfoContent> findUserInfo(String userName, String userNumber, String businessType, String userType){
        return userInfoContentMapper.findUserInfo(userName,userNumber,businessType,userType);
    }
    public int addUserInfo(UserInfoContent userInfoContent){
        int result;
        if(userInfoContentMapper.addUserInfo(userInfoContent)){
           result=1;
        }else{
            result=0;
        }
        return result;
    }
    public UserInfoContent findByUserId(String userId){
        return userInfoContentMapper.findByUserId(userId);
    }
    public int deleteByUserId(String userId){
        int result;
        if(userInfoContentMapper.deleteByUserId(userId)){
            result=1;
        }else{
            result=0;
        }
        return result;
    }
    public int updateUserInfo(UserInfoContent userInfoContent){
        int result;
        if(userInfoContentMapper.updateUserInfo(userInfoContent)){
            result=1;
        }else{
            result=0;
        }
        return result;
    }
    public UserInfoContent findByUserNameId(String userNameId){
       return userInfoContentMapper.findByUserNameId(userNameId);
    }
    public String querymaxEndNo(String startNo){
        return userInfoContentMapper.querymaxEndNo(startNo);
    }
    /**
     * 判断手机号是否已存在
     * */
    public UserInfoContent  findByPhone(String userPhone){
        return userInfoContentMapper.findByUserPhone(userPhone);
    }
    /**
     * 判断身份证号是否已经存在
     * */
    public UserInfoContent findByUserNumber(String userNumber){
      return userInfoContentMapper.findByUserNumber(userNumber);
    }

}
