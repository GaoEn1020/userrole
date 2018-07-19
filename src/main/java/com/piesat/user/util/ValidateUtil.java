package com.piesat.user.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具类
 *
 * Created by zhaoxiaojun on 2018/04/29.
 */
public class ValidateUtil {

    /**
     *邮箱格式验证
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 手机号码格式验证
     */
    public static boolean checkMobile(String mobile){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{4,8}$");
            Matcher matcher = regex.matcher(mobile);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 姓名格式验证
     * @param mobile
     * @return
     */
    public static boolean checkName(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(([\u4e00-\u9fa5]{2,8})||([a-zA-Z]{2,16}))$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 地址格式验证
     * @param mobile
     * @return
     */
    public static boolean checkAdress(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^([\u4e00-\u9fa50-9]{2,30})$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 电话号码格式验证
     * @param mobile
     * @return
     */
    public static boolean checkPhone(String phone){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(\\(?\\d{3,4}[-\\)]?\\d{7,8})$");
            Matcher matcher = regex.matcher(phone);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 可输字符，字母，数字格式验证
     * @param mobile
     * @return
     */
    public static boolean checkAll(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^([\u4e00-\u9fa50-9a-zA-Z]{1,30})$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 可输至多十位汉字格式验证
     * @param mobile
     * @return
     */
    public static boolean checkZi(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^([\u4e00-\u9fa5]{1,10})$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }


    /**
     * 可输至多五位数字格式验证
     * @param mobile
     * @return
     */
    public static boolean checkNumber(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^[1-9]+[0-9]{0,4}$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 时间yyyy-MM-dd格式验证
     * @param mobile
     * @return
     */
    public static boolean checkDate(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 正浮点数格式验证
     * @param mobile
     * @return
     */
    public static boolean checkFu(String name){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$");
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     *身份证格式验证
     */
    public static boolean checkCard(String email){
        boolean flag = false;
        try{
            String check = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

}
