package com.piesat.user.pojo.usercenter;

import java.util.Date;

/**
 * 图片信息表
 *
 * Created by zhaoxiaojun on 2018/05/21.
 */
public class Picture {

    /*图片编号*/
    private String pictureId;
    /*类型*/
    private String pictureType;
    /*上传时间*/
    private Date pictureTime;
    /*原始照片*/
    private String pictureOrginal;
    /*压缩照片*/
    private String pictureCompress;
    /*用户编号*/
    private String userId;
    /*地块编号*/
    private String landId;
    /*异常点编号*/
    private String abnormalId;
    /*影像编号*/
    private String imageId;

    private String pictureNameId;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public Date getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(Date pictureTime) {
        this.pictureTime = pictureTime;
    }

    public String getPictureOrginal() {
        return pictureOrginal;
    }

    public void setPictureOrginal(String pictureOrginal) {
        this.pictureOrginal = pictureOrginal;
    }

    public String getPictureCompress() {
        return pictureCompress;
    }

    public void setPictureCompress(String pictureCompress) {
        this.pictureCompress = pictureCompress;
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

    public String getAbnormalId() {
        return abnormalId;
    }

    public void setAbnormalId(String abnormalId) {
        this.abnormalId = abnormalId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPictureNameId() {
        return pictureNameId;
    }

    public void setPictureNameId(String pictureNameId) {
        this.pictureNameId = pictureNameId;
    }

    public Picture(String pictureId, String pictureType, Date pictureTime, String pictureOrginal, String pictureCompress, String userId, String landId, String abnormalId, String imageId) {
        this.pictureId = pictureId;
        this.pictureType = pictureType;
        this.pictureTime = pictureTime;
        this.pictureOrginal = pictureOrginal;
        this.pictureCompress = pictureCompress;
        this.userId = userId;
        this.landId = landId;
        this.abnormalId = abnormalId;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureType='" + pictureType + '\'' +
                ", pictureTime=" + pictureTime +
                ", pictureOrginal='" + pictureOrginal + '\'' +
                ", pictureCompress=" + pictureCompress +
                ", userId='" + userId + '\'' +
                ", landId='" + landId + '\'' +
                ", abnormalId='" + abnormalId + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }

    public Picture(){}
}
