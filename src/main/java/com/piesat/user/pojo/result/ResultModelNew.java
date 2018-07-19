package com.piesat.user.pojo.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zgf on 2018/2/8.
 * 创建返回前端数据的model
 */
public class ResultModelNew {
    @JSONField(ordinal=1)
    private boolean result;//true,成功;false,失败
    @JSONField(ordinal=2)
    private String message;//返回消息:true,"";false,返回失败原因
    @JSONField(ordinal=3)
    private Object data;//封装数据源
    //private Map<String,Object> data;//封装数据源

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }*/

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
