package com.piesat.user.pojo.result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zgf on 2018/2/12.
 * 将时间格式2017-02-08 10:13:16转为2018-2-8 10:13:16（年、日前的零去掉）
 */
public class TimeTool {
    public static String timeConvert (String str){
        Date date = null;
        SimpleDateFormat sdfTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdfTemp.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        String time = sdf.format(date);
        return time;
    }
}
