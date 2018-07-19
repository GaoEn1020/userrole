package com.piesat.user.pojo.result;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by zgf on 2018/2/5.
 * 创建返回前端数据的model
 */
public class ResultModel {
    @JSONField(ordinal=1)
    private int code;//返回对应的编码
    @JSONField(ordinal=2)
    private String msg;//返回消息
    @JSONField(ordinal=3)
    private Map<String,Object> data;//封装数据源


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ResultModel() {
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
