package com.piesat.user.pojo.usercenter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author libaosen
 * @version 1.0
 * @date 2018年4月20日
 */
public class UserEntity implements Serializable{

    /** 用户编号 */
    private String userId;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String userPassword;

    /** 用户真实名 */
    private String userRealName;

    /** 用户性别 0-男 1-女*/
    private Integer userSex;

    /** 用户手机号 */
    private String userPhone;

    /** 用户身份证号 */
    private String userNumber;

    /** 用户地址 */
    private String userAddress;

    /** 用户邮箱 */
    private String userEmail;

    /** 用户微信 */
    private String userWechat;

    /** 用户状态 0-已注销 1-正常*/
    private Integer userStatus;


    /** 用户注册时间 */
    private Date userRegTime;

    /** 用户类型 0-用户 1-管理员*/
    private Integer userType;

    private String userNameId;

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public UserEntity() {
    }

    public UserEntity(String userId, String userName, String userPassword, String userRealName, Integer userSex, String userPhone, String userNumber, String userAddress, String userEmail, String userWechat, Integer userStatus, Date userRegTime, Integer userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealName = userRealName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userNumber = userNumber;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userWechat = userWechat;
        this.userStatus = userStatus;
        this.userRegTime = userRegTime;
        this.userType = userType;
    }

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

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }


    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userSex=" + userSex +
                ", userPhone='" + userPhone + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userWechat='" + userWechat + '\'' +
                ", userStatus=" + userStatus +
                ", userRegTime=" + userRegTime +
                ", userType=" + userType +
                '}';
    }
}
