package com.piesat.user.util;

/**
 * Created by yangdong on 2018/03/26.
 */
public class StringUtil {
    /**
     * 判断是否是空字符串 null和"" null返回result,否则返回字符串
     *
     * @param s
     * @return
     */
    public static String isEmpty(String s, String result) {
        if (s != null && !s.equals("")) {
            return s;
        }
        return result;
    }

    /**
     * 判断对象是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public static boolean objIsEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if (object.equals("")) {
            return (true);
        }
        return object.equals("null");
    }

    public static boolean objIsNotEmpty(Object object) {
        return object != null && !object.equals("") && !object.equals("null") && !object.equals("undefined");
    }

    /**
     * 转化成2位字符串，补0
     *
     */
    public static String intToStr(int str) {
        String st = String.valueOf(str);
        if(st.length() == 2){
            return st;
        }else {
            return "0"+st;
        }
    }
    /**
     * 转化成3位字符串，补00
     *
     */
    public static String intThreeStr(int str) {
        String st = String.valueOf(str);
        if(st.length() == 3){
            return st;
        }else if(st.length() == 2){
            return "0"+st;
        }else{
            return "00"+st;
        }
    }
    /**
     * 转化成4位字符串，补000
     *
     */
    public static String intFourStr(int str) {
        String st = String.valueOf(str);
        if(st.length() == 4){
            return st;
        }else if(st.length() == 3){
            return "0"+st;
        }else if(st.length() == 2){
            return "00"+st;
        }else{
            return "000"+st;
        }
    }
    /**
     * 转化成6位字符串，补000
     *
     */
    public static String intSixStr(int str) {
        String st = String.valueOf(str);
        if(st.length() == 6){
            return st;
        }else if(st.length() == 5){
            return "0"+st;
        }else if(st.length() == 4){
            return "00"+st;
        }else if(st.length() == 3){
            return "000"+st;
        }else if(st.length() == 2){
            return "0000"+st;
        }else{
            return "00000"+st;
        }
    }


    /**
     * 风速转换风级
     *
     */
    public static double weedGrade(Double ws) {
        if(ws >= 0.0 &&  ws<= 0.2 ){
            return 0;
        }else if(ws >= 0.3 && ws <= 1.5 ){
            return 1;
        }else if(ws >= 1.6 && ws <= 3.3 ){
            return 2;
        }else if(ws >= 3.4 && ws <= 5.4 ){
            return 3;
        }else if(ws >= 5.5 && ws <= 7.9 ){
            return 4;
        }else if(ws >= 8.0 && ws <= 10.7 ){
            return 5;
        }else if(ws >= 10.8 && ws <= 13.8 ){
            return 6;
        }else if(ws >= 13.9 && ws <= 17.1 ){
            return 7;
        }else if(ws >= 17.2 && ws <= 20.7 ){
            return 8;
        }else if(ws >= 20.8 && ws <= 24.4 ){
            return 9;
        }else if(ws >= 24.5 && ws <= 28.4 ){
            return 10;
        }else if(ws >= 28.5 && ws <= 38.6 ){
            return 11;
        }else{
            return 12;
        }
    }

}
