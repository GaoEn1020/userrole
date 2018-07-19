package com.piesat.user.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * Created by zhaoxiaojun on 2018/03/27.
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
