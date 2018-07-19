package com.piesat.user.pojo.result;

import java.util.Map;

/**
 * Created by zgf on 2018/2/5.
 * 请求结果处理类ResultTools.java
 */
public class ResultTools {
    /**
     * 代号表示code
     * 0000----->"成功"
     * 1000----->"添加失败"
     * 2000----->"删除失败"
     * 3000----->"修改失败"
     * 1001----->"请求传参错误"
     * 1002----->"未找到对应内容"
     * 1003----->"此名称已存在"
     * 444----->""异常抛出错误
     */

    /**
     * @param code---具体代号
     * @param msg---444服务器内部异常时提示消息(返回码不是444时传空即可)
     * @param map---数据源
     */

    public static ResultModel result(int code, String msg, Map<String,Object>map){
        ResultModel model = new ResultModel();
        model.setCode(code);
        switch (code) {
            case 0:
                model.setMsg("成功!");
                if(map != null){
                    model.setData(map);
                }
                break;
            case 1000:
                model.setMsg("添加失败！");
                break;
            case 2000:
                model.setMsg("删除失败！");
                break;
            case 3000:
                model.setMsg("修改失败！");
                break;
            case 1001:
                model.setMsg("请求传参错误！");
                break;
            case 1002:
                model.setMsg("未找到对应内容！");
                break;
            case 1003:
                model.setMsg("此名称已存在！");
                break;
            case 444:
                model.setMsg(msg);
                break;
            default:
                model.setMsg("未知错误！");
                break;
        }
        return model;
    }

}
