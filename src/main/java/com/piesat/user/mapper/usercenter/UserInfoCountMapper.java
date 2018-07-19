package com.piesat.user.mapper.usercenter;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaoxiaojun on 2018/04/30.
 */
@Repository
public interface UserInfoCountMapper {

    Integer queryUserLandCount(@Param("userId") String userId);

    Double queryUserInfoCountAreaSum(@Param("userId") String userId);

    Integer queryUserInfoCountMessageSum(@Param("userId") String userId);

    String queryUserInfoCountServe(@Param("userId") String userId);
}
