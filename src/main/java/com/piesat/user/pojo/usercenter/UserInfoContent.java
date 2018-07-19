package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息表 scenery_userinfo
 * */
public class UserInfoContent {
    /**用户编号*/
    @JSONField(ordinal=1)
    private String userId;
    /**用户名*/
    @JSONField(ordinal=2)
    private String userName;
    /**用户密码*/
    @JSONField(ordinal=3)
    private String userPassword;
    /**用户姓名*/
    @JSONField(ordinal=4)
    private String userRealname;
    /**用户性别*/
    @JSONField(ordinal=5)
    private int userSex;
    /**用户手机号*/
    @JSONField(ordinal=6)
    private String userPhone;
    /**用户身份证号*/
    @JSONField(ordinal=7)
    private String userNumber;
    /**用户地址*/
    @JSONField(ordinal=8)
    private String userAddress;
    /**用户邮箱*/
    @JSONField(ordinal=9)
    private String userMail;
    /**用户服务期限*/
    @JSONField(ordinal=10)
    private String userServe;
    /**用户微信*/
    @JSONField(ordinal=11)
    private String userWechat;
    /**用户状态*/
    @JSONField(ordinal=12)
    private int userStaus;
    /**用户注册时间*/
    @JSONField(ordinal=13)
    private String userRegTime;
    /**用户类型*/
    @JSONField(ordinal=14)
    private Integer userType;
    /**田地面积*/
    @JSONField(ordinal=15)
    private double landArea;
    /**经营类型*/
    @JSONField(ordinal=16)
    private int businessType;
    /**土地数量*/
    @JSONField(ordinal=17)
    private int landNumber;
    @JSONField(ordinal=18)
    private String userNameId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserServe() {
        return userServe;
    }

    public void setUserServe(String userServe) {
        this.userServe = userServe;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public int getUserStaus() {
        return userStaus;
    }

    public void setUserStaus(int userStaus) {
        this.userStaus = userStaus;
    }

    public String getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(String userRegTime) {
        this.userRegTime = userRegTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public int getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(int landNumber) {
        this.landNumber = landNumber;
    }

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public UserInfoContent() {
    }

    public UserInfoContent(String userId, String userName, String userPassword, String userRealname, int userSex, String userPhone, String userNumber, String userAddress, String userMail, String userServe, String userWechat, int userStaus, String userRegTime, Integer userType,double landArea,int businessType,int landNumber,String userNameId) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealname = userRealname;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userNumber = userNumber;
        this.userAddress = userAddress;
        this.userMail = userMail;
        this.userServe = userServe;
        this.userWechat = userWechat;
        this.userStaus = userStaus;
        this.userRegTime = userRegTime;
        this.userType = userType;
        this.landArea=landArea;
        this.businessType=businessType;
        this.landNumber=landNumber;
        this.userNameId=userNameId;
    }

    @Override
    public String toString() {
        return "UserInfoContent{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userSex=" + userSex +
                ", userPhone='" + userPhone + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userServe='" + userServe + '\'' +
                ", userWechat='" + userWechat + '\'' +
                ", userStaus=" + userStaus +
                ", userRegTime='" + userRegTime + '\'' +
                ", userType=" + userType +
                '}';
    }
}
