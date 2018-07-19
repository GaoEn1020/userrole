package com.piesat.user.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author libaosen
 * @version 1.0
 * @date 2018年4月28日
 */
public class PasswordValidUtil {

    public static boolean validPwd(String password){
        boolean flag = true;

        // 判断str是否为手机号

        String regex = "^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])).{6,12}$";



        int len = password.trim().length();


        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        boolean isMatch = m.matches();

        if(len<6||len>12||!isMatch){
            flag = false;
        }
        return flag;
    }
}
