package com.piesat.user.pojo.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zgf on 2018/2/28.
 * 将消息主键编号(messageId) long类型转为字符串"messageId",方便前端显示
 */
public class FieldMetadataConvert {
    @JSONField(ordinal=1)
    private int id ;//主键编号
    @JSONField(ordinal=2)
    private String messageId;//消息主键编号
    @JSONField(ordinal=3)
    private long packetId;//数据包主键编号
    @JSONField(ordinal=4)
    private String fieldName;//字段名称
    @JSONField(ordinal=5)
    private String fieldLabel;//控制循环字段
    @JSONField(ordinal=6)
    private boolean fieldDecision;//决定子消息内容的字段
    @JSONField(ordinal=7)
    private int typeId;//字段类型编号
    @JSONField(ordinal=8)
    private boolean fieldAttri;//消息头or消息体
    @JSONField(ordinal=9)
    private int fieldQuantization;//数据纲量编号
    @JSONField(ordinal=10)
    private int fieldLength;//字段比特长度
    @JSONField(ordinal=11)
    private int fieldOriginalPosition;//数据始位置
    @JSONField(ordinal=12)
    private String fieldDescribe;//字段描述说明
    @JSONField(ordinal=13)
    private int fieldMaxValue;//字段最大值编号
    @JSONField(ordinal=14)
    private int fieldMinValue;//字段最小值编号
    @JSONField(ordinal=15)
    private String complexFieldName;//复合字段名称
    @JSONField(ordinal=16)
    private boolean isFieldRule;//字段解析规则标识
    @JSONField(ordinal=17)
    private String createtime;//创建时间

    public FieldMetadataConvert() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getPacketId() {
        return packetId;
    }

    public void setPacketId(long packetId) {
        this.packetId = packetId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public boolean isFieldDecision() {
        return fieldDecision;
    }

    public void setFieldDecision(boolean fieldDecision) {
        this.fieldDecision = fieldDecision;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isFieldAttri() {
        return fieldAttri;
    }

    public void setFieldAttri(boolean fieldAttri) {
        this.fieldAttri = fieldAttri;
    }

    public int getFieldQuantization() {
        return fieldQuantization;
    }

    public void setFieldQuantization(int fieldQuantization) {
        this.fieldQuantization = fieldQuantization;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    public int getFieldOriginalPosition() {
        return fieldOriginalPosition;
    }

    public void setFieldOriginalPosition(int fieldOriginalPosition) {
        this.fieldOriginalPosition = fieldOriginalPosition;
    }

    public String getFieldDescribe() {
        return fieldDescribe;
    }

    public void setFieldDescribe(String fieldDescribe) {
        this.fieldDescribe = fieldDescribe;
    }

    public int getFieldMaxValue() {
        return fieldMaxValue;
    }

    public void setFieldMaxValue(int fieldMaxValue) {
        this.fieldMaxValue = fieldMaxValue;
    }

    public int getFieldMinValue() {
        return fieldMinValue;
    }

    public void setFieldMinValue(int fieldMinValue) {
        this.fieldMinValue = fieldMinValue;
    }

    public String getComplexFieldName() {
        return complexFieldName;
    }

    public void setComplexFieldName(String complexFieldName) {
        this.complexFieldName = complexFieldName;
    }

    public boolean getIsFieldRule() {
        return isFieldRule;
    }

    public void setIsFieldRule(boolean isFieldRule) {
        this.isFieldRule = isFieldRule;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

}
