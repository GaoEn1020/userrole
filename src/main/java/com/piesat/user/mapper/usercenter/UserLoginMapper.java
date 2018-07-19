package com.piesat.user.mapper.usercenter;

import com.piesat.user.pojo.usercenter.UserLogin;
import org.springframework.stereotype.Repository;

/**
 * add by wangxin 2018/06/19
 * */
@Repository
public interface UserLoginMapper {
    boolean addUserLogin(UserLogin userLogin);
}
