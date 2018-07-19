package com.piesat.user.pojo.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zgf on 2018/2/28.
 */
public class MessageMetadataConvert {
    @JSONField(ordinal=1)
    private String id ;//主键编号，long转为string
    @JSONField(ordinal=2)
    private int messageId;//消息编号
    @JSONField(ordinal=3)
    private int messageStage;//消息层数
    @JSONField(ordinal=4)
    private String messageName;//消息名称
    @JSONField(ordinal=5)
    private String messageDescription;//消息描述
    @JSONField(ordinal=6)
    private int messageCategoryId;//消息分类编号
    @JSONField(ordinal=7)
    private long childMessageId;//子消息ID
    @JSONField(ordinal=8)
    private boolean isRealTime;//是否支持实时计算
    @JSONField(ordinal=9)
    private int messageCategoryRuleId;//消息解析规则分类编号
    @JSONField(ordinal=10)
    private boolean isFixedLength;//是否定长消息
    @JSONField(ordinal=11)
    private String createtime;//创建时间

    public MessageMetadataConvert() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getMessageStage() {
        return messageStage;
    }

    public void setMessageStage(int messageStage) {
        this.messageStage = messageStage;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public int getMessageCategoryId() {
        return messageCategoryId;
    }

    public void setMessageCategoryId(int messageCategoryId) {
        this.messageCategoryId = messageCategoryId;
    }

    public long getChildMessageId() {
        return childMessageId;
    }

    public void setChildMessageId(long childMessageId) {
        this.childMessageId = childMessageId;
    }

    public boolean getIsRealTime() {
        return isRealTime;
    }

    public void setIsRealTime(boolean isRealTime) {
        this.isRealTime = isRealTime;
    }

    public int getMessageCategoryRuleId() {
        return messageCategoryRuleId;
    }

    public void setMessageCategoryRuleId(int messageCategoryRuleId) {
        this.messageCategoryRuleId = messageCategoryRuleId;
    }

    public boolean getIsFixedLength() {
        return isFixedLength;
    }

    public void setIsFixedLength(boolean isFixedLength) {
        this.isFixedLength = isFixedLength;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
