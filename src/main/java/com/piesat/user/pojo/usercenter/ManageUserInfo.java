package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class ManageUserInfo {
    //编号
    @JSONField(ordinal=1)
    private String manageUserId;
    //管理员姓名
    @JSONField(ordinal=2)
    private String manageUserName;
    //管理员电话
    @JSONField(ordinal=3)
    private String manageUserPhone;
    //创建时间
    @JSONField(ordinal=4,format = "YYYY-MM-dd")
    private Date manageUserTime;
    //所在部门
    @JSONField(ordinal=5)
    private String manageUserDepart;
    //密码
    @JSONField(ordinal=6)
    private String manageUserPassWord;
    //性别
    @JSONField(ordinal=7)
    private int manageUserSex;
    //身份证号
    @JSONField(ordinal=8)
    private String manageUserNumber;
    //地址
    @JSONField(ordinal=9)
    private String manageUserAddress;
    //邮箱
    @JSONField(ordinal=10)
    private String manageUserMail;
    //微信
    @JSONField(ordinal=11)
    private String manageUserWechat;

    @JSONField(ordinal = 12)
    private String manageUserStatus;
    //管理员姓名
    @JSONField(ordinal=13)
    private String manageUserNameId;

    //真实姓名
    private String manageUserRealName;

    public String getManageUserRealName() {
        return manageUserRealName;
    }

    public void setManageUserRealName(String manageUserRealName) {
        this.manageUserRealName = manageUserRealName;
    }

    //角色编号
    private String roleId;
    //管理等级
    private String roleName;

    public String getManageUserNameId() {
        return manageUserNameId;
    }

    public void setManageUserNameId(String manageUserNameId) {
        this.manageUserNameId = manageUserNameId;
    }

    public String getManageUserStatus() {
        return manageUserStatus;
    }

    public void setManageUserStatus(String manageUserStatus) {
        this.manageUserStatus = manageUserStatus;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getManageUserTime() {
        return manageUserTime;
    }

    public void setManageUserTime(Date manageUserTime) {
        this.manageUserTime = manageUserTime;
    }

    public int getManageUserSex() {
        return manageUserSex;
    }

    public void setManageUserSex(int manageUserSex) {
        this.manageUserSex = manageUserSex;
    }

    public String getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(String manageUserId) {
        this.manageUserId = manageUserId;
    }

    public String getManageUserName() {
        return manageUserName;
    }

    public void setManageUserName(String manageUserName) {
        this.manageUserName = manageUserName;
    }

    public String getManageUserPhone() {
        return manageUserPhone;
    }

    public void setManageUserPhone(String manageUserPhone) {
        this.manageUserPhone = manageUserPhone;
    }

    public String getManageUserDepart() {
        return manageUserDepart;
    }

    public void setManageUserDepart(String manageUserDepart) {
        this.manageUserDepart = manageUserDepart;
    }

    public String getManageUserPassWord() {
        return manageUserPassWord;
    }

    public void setManageUserPassWord(String manageUserPassWord) {
        this.manageUserPassWord = manageUserPassWord;
    }

    public String getManageUserNumber() {
        return manageUserNumber;
    }

    public void setManageUserNumber(String manageUserNumber) {
        this.manageUserNumber = manageUserNumber;
    }

    public String getManageUserAddress() {
        return manageUserAddress;
    }

    public void setManageUserAddress(String manageUserAddress) {
        this.manageUserAddress = manageUserAddress;
    }

    public String getManageUserMail() {
        return manageUserMail;
    }

    public void setManageUserMail(String manageUserMail) {
        this.manageUserMail = manageUserMail;
    }

    public String getManageUserWechat() {
        return manageUserWechat;
    }

    public void setManageUserWechat(String manageUserWechat) {
        this.manageUserWechat = manageUserWechat;
    }
}
