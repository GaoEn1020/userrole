package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户登陆实体类 与数据库表user_login对应
 * add by wangxin 2018/06/18
 * */
public class UserLogin {
    /*登陆编号*/
    @JSONField(ordinal=1)
    private String loginId;
    /*用户编号*/
    @JSONField(ordinal=1)
    private String userId;
    /*登陆时间*/
    @JSONField(ordinal=1)
    private String loginTime;
    /*登陆状态*/
    @JSONField(ordinal=1)
    private Integer loginStatus;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public UserLogin() {
    }

    public UserLogin(String loginId, String userId, String loginTime, Integer loginStatus) {
        this.loginId = loginId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "loginId='" + loginId + '\'' +
                ", userId='" + userId + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginStatus=" + loginStatus +
                '}';
    }
}

