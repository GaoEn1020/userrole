package com.piesat.user.mapper.usercenter;

import com.piesat.user.pojo.usercenter.UserCountInfo;
import com.piesat.user.pojo.usercenter.UserInfo;
import com.piesat.user.pojo.usercenter.UserMessage;
import com.piesat.user.pojo.usercenter.UserView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaoxiaojun on 2018/04/23.
 */
@Repository
public interface UserInfoMapper {

    UserInfo findStausAndType(String userId);

    UserInfo queryUserInfo(String userId);

    boolean updateUserInfo(UserInfo userInfo);

    List<UserMessage> queryUserMessage(String userId);

    UserMessage findUserMessageById(@Param("messageId") String messageId);

    boolean deleteUserMessage(@Param("userId") String userId, @Param("messageId") String messageId);

    boolean updateUserMessage(@Param("messageId") String messageId);

    List<UserInfo> queryUserInfoList();

    UserMessage findUserMessageContentByZero(String userId);

    UserMessage findUserMessageContentByOne(String userId);

    UserMessage findUserMessageContentByTwo(String userId);

    UserMessage findUserMessageContentByThree(String userId);

    UserMessage findUserMessageContentByFour(String userId);

    boolean addUserView(UserView userView);
    List<UserView> userViewFind(@Param("userId") String userId);

    /**
     * 整理用户信息
     * @param userId
     * @return
     */
    List<UserCountInfo> userSumInfo(@Param("userId") String userId, @Param("userNameId") String userNameId);
    /**
     * 根据nameID查询
     * @param userNameId
     * @return
     */
    UserInfo findByNameId(String userNameId);

}
