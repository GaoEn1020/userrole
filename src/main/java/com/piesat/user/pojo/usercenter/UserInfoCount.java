package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息统计类
 *
 * Created by zhaoxiaojun on 2018/04/30.
 */
public class UserInfoCount {

    /**用户统计编号*/
    @JSONField(ordinal=1)
    private String userInfoCountId;
    /**用户地块总数*/
    @JSONField(ordinal=2)
    private Integer userInfoCountNumber;
    /**用户地块总面积*/
    @JSONField(ordinal=3)
    private Double userInfoCountAreaSum;
    /**用户消息总数*/
    @JSONField(ordinal=4)
    private Integer userInfoCountMessageSum;
    /**用户服务期限*/
    @JSONField(ordinal=5)
    private String userInfoCountServe;
    /**用户编号*/
    @JSONField(ordinal=6)
    private String userId;
    /**用户消息编号*/
    @JSONField(ordinal=7)
    private String messageId;
    /**用户地块编号*/
    @JSONField(ordinal=8)
    private String landId;

    public String getUserInfoCountId() {
        return userInfoCountId;
    }

    public void setUserInfoCountId(String userInfoCountId) {
        this.userInfoCountId = userInfoCountId;
    }

    public Integer getUserInfoCountNumber() {
        return userInfoCountNumber;
    }

    public void setUserInfoCountNumber(Integer userInfoCountNumber) {
        this.userInfoCountNumber = userInfoCountNumber;
    }

    public Double getUserInfoCountAreaSum() {
        return userInfoCountAreaSum;
    }

    public void setUserInfoCountAreaSum(Double userInfoCountAreaSum) {
        this.userInfoCountAreaSum = userInfoCountAreaSum;
    }

    public Integer getUserInfoCountMessageSum() {
        return userInfoCountMessageSum;
    }

    public void setUserInfoCountMessageSum(Integer userInfoCountMessageSum) {
        this.userInfoCountMessageSum = userInfoCountMessageSum;
    }

    public String getUserInfoCountServe() {
        return userInfoCountServe;
    }

    public void setUserInfoCountServe(String userInfoCountServe) {
        this.userInfoCountServe = userInfoCountServe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }

    public UserInfoCount(String userInfoCountId, Integer userInfoCountNumber, Double userInfoCountAreaSum, Integer userInfoCountMessageSum, String userInfoCountServe, String userId, String messageId, String landId) {
        this.userInfoCountId = userInfoCountId;
        this.userInfoCountNumber = userInfoCountNumber;
        this.userInfoCountAreaSum = userInfoCountAreaSum;
        this.userInfoCountMessageSum = userInfoCountMessageSum;
        this.userInfoCountServe = userInfoCountServe;
        this.userId = userId;
        this.messageId = messageId;
        this.landId = landId;
    }

    public UserInfoCount(){}

    @Override
    public String toString() {
        return "UserInfoCount{" +
                "userInfoCountId='" + userInfoCountId + '\'' +
                ", userInfoCountNumber=" + userInfoCountNumber +
                ", userInfoCountAreaSum=" + userInfoCountAreaSum +
                ", userInfoCountMessageSum=" + userInfoCountMessageSum +
                ", userInfoCountServe='" + userInfoCountServe + '\'' +
                ", userId='" + userId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", landId='" + landId + '\'' +
                '}';
    }
}
