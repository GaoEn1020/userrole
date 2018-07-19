package com.piesat.user.mapper.usermapper;

import com.piesat.user.pojo.usercenter.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问层类
 *
 * @author libaosen
 * @version 1.0
 * @date 2018年4月25日
 */



@Repository
public interface UserMapper {

    /**
     * 通过用户名查询对象
     *
     * @param userName
     * @return
     */
    UserEntity selectByName(@Param(value = "userName") String userName);


    /**
     * 用户登陆接口
     *
     * @param userName
     * @param userPassword
     * @return
     */
    UserEntity login(@Param(value = "userName") String userName, @Param(value = "userPassword") String userPassword);

    /**
     * 通过主键查询对象
     *
     * @param userId
     * @return
     */
    UserEntity selectByPrimaryKey(@Param(value = "userId") String userId);


    /**
     * 更改密码
     *
     * @param userId
     * @param userPassword
     * @return
     */
    int updatePwdByUserId(@Param(value = "userId") String userId, @Param(value = "userPassword") String userPassword);

    /**
     * 通过手机号查询对象
     *
     * @param userPhone
     * @return
     */
    UserEntity selectByUserPhone(@Param(value = "userPhone") String userPhone);

    List<String> getUserId();

}
