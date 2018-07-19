package com.piesat.user.pojo.usercenter;


/**
 * 后管中用户列表
 */
public class UserCountInfo {
    //用户编号
    private String userId;
    //用户名称
    private String userName;
    //总地块数
    private int sumLand;
    //地块总面积
    private Double sumArea;
    //总影响数
    private int sumImage;
    //总照片数
    private int sumPhoto;

    //状态
    private String userStaus;

    public String getUserStaus() {
        return userStaus;
    }

    public void setUserStaus(String userStaus) {
        this.userStaus = userStaus;
    }

    //用户name编号\
    private String userNameId;

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
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

    public int getSumLand() {
        return sumLand;
    }

    public void setSumLand(int sumLand) {
        this.sumLand = sumLand;
    }

    public Double getSumArea() {
        return sumArea;
    }

    public void setSumArea(Double sumArea) {
        this.sumArea = sumArea;
    }

    public int getSumImage() {
        return sumImage;
    }

    public void setSumImage(int sumImage) {
        this.sumImage = sumImage;
    }

    public int getSumPhoto() {
        return sumPhoto;
    }

    public void setSumPhoto(int sumPhoto) {
        this.sumPhoto = sumPhoto;
    }
}
