package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by fanxiaodan on 2018/07/17.
 * 订单表  对应数据库中order_manage表
 */
public class OrderManage {

    @JSONField(ordinal = 1)
    private String orderId;
    @JSONField(ordinal = 2)
    private String userId;
    @JSONField(ordinal = 3)
    private String userServeDeadline;
    @JSONField(ordinal = 4)
    private String userServeType;
    @JSONField(ordinal = 5, format = "YYYY-MM-dd HH:mm:ss")
    private Date orderTime;

    @JSONField(ordinal = 6)
    private String orderDel;

    private String userNameId;
    private String userName;
    private Date orderTimeStart;
    private Date orderTimeEnd;

    private String userPhone;
    private String userWechat;
    private String userMail;
    private String userAddress;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(Date orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public Date getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(Date orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderDel() {
        return orderDel;
    }

    public void setOrderDel(String orderDel) {
        this.orderDel = orderDel;
    }

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserServeDeadline() {
        return userServeDeadline;
    }

    public void setUserServeDeadline(String userServeDeadline) {
        this.userServeDeadline = userServeDeadline;
    }

    public String getUserServeType() {
        return userServeType;
    }

    public void setUserServeType(String userServeType) {
        this.userServeType = userServeType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
