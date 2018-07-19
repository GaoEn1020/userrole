package com.piesat.user.util;

/**
 * 对象判断工具类
 *
 * @author libaosen
 * @version 1.0
 * @date 2018年4月25日
 */
public class StrUtil {

    public static boolean isNotNull(Object object){
        if(object==null){
            return false;
        }
        if("".equals(object.toString().trim())){
            return false;
        }
        if("null".equals(object)){
             return false;
        }
        return !"undefined".equals(object);
    }
}
