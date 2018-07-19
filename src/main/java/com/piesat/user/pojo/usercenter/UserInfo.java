package com.piesat.user.pojo.usercenter;

import java.util.Date;

/**
 * 用户信息表，与数据库中的SCENERY_USERINFO表对应
 *
 * Created by zhaoxiaojun on 2018/03/27.
 */

public class UserInfo {

    /*用户编号*/
    private String userId;
    /*用户名标识ID*/
    private String userNameId;
    /*用户名*/
    private String userName;
    /*用户密码*/
    private String userPassword;
    /*用户姓名*/
    private String userRealname;
    /*用户性别 0 男 1 女*/
    private Integer userSex;
    /*用户手机号*/
    private String userPhone;
    /*用户身份证号*/
    private String userNumber;
    /*用户地址*/
    private String userAddress;
    /*用户邮箱*/
    private String userMail;
    /*用户微信*/
    private String userWechat;
    /*用户服务期限*/
    private String userServe;
    /*用户状态*/
    private Integer userStaus;
    /*用户注册日期*/
    private Date userRegtime;
    /*用户类型 0 用户 1 管理员*/
    private Integer userType;
    /*用户服务类型*/
    private String userServeType;

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

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
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

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public Integer getUserStaus() {
        return userStaus;
    }

    public void setUserStaus(Integer userStaus) {
        this.userStaus = userStaus;
    }

    public Date getUserRegtime() {
        return userRegtime;
    }

    public void setUserRegtime(Date userRegtime) {
        this.userRegtime = userRegtime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserServe() {
        return userServe;
    }

    public void setUserServe(String userServe) {
        this.userServe = userServe;
    }

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public String getUserServeType() {
        return userServeType;
    }

    public void setUserServeType(String userServeType) {
        this.userServeType = userServeType;
    }

    public UserInfo(String userId, String userName, String userPassword, String userRealname, Integer userSex, String userPhone, String userNumber, String userAddress, String userMail, String userWechat, String userServe, Integer userStaus, Date userRegtime, Integer userType,String userServeType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealname = userRealname;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userNumber = userNumber;
        this.userAddress = userAddress;
        this.userMail = userMail;
        this.userWechat = userWechat;
        this.userServe = userServe;
        this.userStaus = userStaus;
        this.userRegtime = userRegtime;
        this.userType = userType;
        this.userServeType=userServeType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userSex=" + userSex +
                ", userPhone='" + userPhone + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userWechat='" + userWechat + '\'' +
                ", userServe='" + userServe + '\'' +
                ", userStaus=" + userStaus +
                ", userRegtime=" + userRegtime +
                ", userType=" + userType +
                '}';
    }

    public UserInfo(){

    }
}
