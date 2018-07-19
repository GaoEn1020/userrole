package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 用户消息实体类
 *
 * Created by zhaoxiaojun on 2018/04/17.
 */
public class UserMessage {

    /*消息编号*/
    @JSONField(ordinal=1)
    private String messageId;
    /*消息类型*/
    @JSONField(ordinal=2)
    private String messageType;
    /*种植指导类型*/
    @JSONField(ordinal=3)
    private String plantGuideType;
    /*消息内容*/
    @JSONField(ordinal=4)
    private String messageContent;
    /*消息发送时间 */
    @JSONField(ordinal=5,format = "yyyy-MM-dd HH:mm:ss")
    private Date messageSendTime;
    /*消息是否读取 */
    @JSONField(ordinal=6)
    private String messageStaus;
    /*地块编号*/
    @JSONField(ordinal=7)
    private String landId;
    /*用户编号*/
    @JSONField(ordinal=8)
    private String userId;
    /*备注*/
    @JSONField(ordinal = 9)
    private String remark;
    /*是否删除消息  0删除  1存在*/
    @JSONField(ordinal = 10)
    private int messageCancel;


    private Date messageSendTimeStart;

    private Date messageSendTimeEnd;



    private String userName;
    private String landName;

    private String userNameId;
    private String landNameId;
    private String messageNameId;

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public String getLandNameId() {
        return landNameId;
    }

    public void setLandNameId(String landNameId) {
        this.landNameId = landNameId;
    }

    public String getMessageNameId() {
        return messageNameId;
    }

    public void setMessageNameId(String messageNameId) {
        this.messageNameId = messageNameId;
    }

    public Date getMessageSendTimeStart() {
        return messageSendTimeStart;
    }

    public void setMessageSendTimeStart(Date messageSendTimeStart) {
        this.messageSendTimeStart = messageSendTimeStart;
    }

    public Date getMessageSendTimeEnd() {
        return messageSendTimeEnd;
    }

    public void setMessageSendTimeEnd(Date messageSendTimeEnd) {
        this.messageSendTimeEnd = messageSendTimeEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public int getMessageCancel() {
        return messageCancel;
    }

    public void setMessageCancel(int messageCancel) {
        this.messageCancel = messageCancel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getPlantGuideType() {
        return plantGuideType;
    }

    public void setPlantGuideType(String plantGuideType) {
        this.plantGuideType = plantGuideType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public String getMessageStaus() {
        return messageStaus;
    }

    public void setMessageStaus(String messageStaus) {
        this.messageStaus = messageStaus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }

    public UserMessage(String messageId, String messageType, String plantGuideType, String messageContent, Date messageSendTime, String messageStaus, String landId, String userId) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.plantGuideType = plantGuideType;
        this.messageContent = messageContent;
        this.messageSendTime = messageSendTime;
        this.messageStaus = messageStaus;
        this.landId = landId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "messageId='" + messageId + '\'' +
                ", messageType='" + messageType + '\'' +
                ", plantGuideType='" + plantGuideType + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageSendTime=" + messageSendTime +
                ", messageStaus='" + messageStaus + '\'' +
                ", landId='" + landId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public UserMessage(){

    }

}
