package com.piesat.user.service.usercenter;


import com.piesat.user.mapper.usercenter.UserLoginMapper;
import com.piesat.user.pojo.usercenter.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * add by wangxin 2018/06/19
 * */
@Service
@Transactional
public class UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    public int addUserLogin(UserLogin userLogin){
      int number;
      if(userLoginMapper.addUserLogin(userLogin)){
          number=1;
      }else{
          number=0;
      }
       return number;
    }
}
