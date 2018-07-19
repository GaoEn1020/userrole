package com.piesat.user.pojo.result;

/**
 * Created by zgf on 2018/2/8.
 * 请求结果处理类ResultToolsNew.java
 */
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
 * result---true/false
 * error---内部异常时提示消息
 *  map---数据源
 */
public class ResultToolsNew {
    public static ResultModelNew result(boolean result, String message, Object map){
        ResultModelNew model = new ResultModelNew();
        model.setResult(result);
        if(result==true){
            model.setMessage("");
            if(map != null){
                model.setData(map);
            }
        }else{
            if(message != null){
                model.setMessage(message);
            }
           model.setData("");
        }
        /*switch (result) {
            case true:
                model.setError("");
                if(map != null){
                    model.setData(map);
                }
                break;
            case false:
                model.setError(error);
                model.setData(null);
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
                model.setError("未知错误！");
                model.setData(null);
                break;
        }*/
        return model;
    }
}
