package com.piesat.user.mapper.usercenter;

import com.piesat.user.pojo.usercenter.UserInfoContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  Created by wangxin on 2018/05/31.
 * */
@Repository
public interface UserInfoContentMapper {
    List<UserInfoContent> findUserInfo(@Param("userName") String userName, @Param("userNumber") String userNumber, @Param("businessType") String businessType, @Param("userType") String userType);
    boolean addUserInfo(UserInfoContent userInfoContent);
    UserInfoContent findByUserId(@Param("userId") String userId);
    boolean deleteByUserId(@Param("userId") String userId);
    boolean updateUserInfo(UserInfoContent userInfoContent);
    UserInfoContent findByUserNameId(@Param("userNameId") String userNameId);
    String querymaxEndNo(String startNo);
    UserInfoContent findByUserPhone(@Param("userPhone") String userPhone);
    UserInfoContent findByUserNumber(@Param("userNumber") String userNumber);
}
