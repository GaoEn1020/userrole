package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class UserView {
    //编号
    @JSONField(ordinal = 1)
    private String viewId;
    //反馈时间
    @JSONField(ordinal = 2,format = "yyyy-MM-dd HH:mm:ss")
    private Date viewDate;
    //反馈意见
    @JSONField(ordinal = 3)
    private String viewInfo;
    //用户编号
    @JSONField(ordinal = 4)
    private String userId;

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public String getViewInfo() {
        return viewInfo;
    }

    public void setViewInfo(String viewInfo) {
        this.viewInfo = viewInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
