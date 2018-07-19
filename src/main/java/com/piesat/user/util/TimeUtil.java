package com.piesat.user.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yangdong on 2018/03/27.
 *
 */
public class TimeUtil {

    /**
     * 将前端的时间字符串转为时间戳（毫秒的时间戳）
     *
     * @param s
     * @return
     */
    public static Long dateToStamp(String s) {
        Long l = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d;
            d = format.parse(s);
            long temp = d.getTime();
            l=temp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l;
    }


    // 各种时间格式
    public static final SimpleDateFormat date_sdf = new SimpleDateFormat(
            "yyyy-MM-dd");
    // 各种时间格式
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd");
    public static final SimpleDateFormat yyyyMM = new SimpleDateFormat(
            "yyyyMM");
    public static final SimpleDateFormat yyyyMMddHH = new SimpleDateFormat(
            "yyyyMMddHH");
    public static final SimpleDateFormat MMdd = new SimpleDateFormat(
            "MMdd");
    public static final SimpleDateFormat ddHH = new SimpleDateFormat(
            "ddHH");
    public static final SimpleDateFormat yyyy = new SimpleDateFormat(
            "yyyy");
    public static final SimpleDateFormat date_sdf_yyyy = new SimpleDateFormat(
            "yyyy");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat(
            "yyyy年MM月dd日");
    public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
            "HH:mm");
    public static final  SimpleDateFormat datetimeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    // 以毫秒表示的时间
    private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
    private static final long HOUR_IN_MILLIS = 3600 * 1000;
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long SECOND_IN_MILLIS = 1000;
    // 指定模式的时间格式
    private static SimpleDateFormat getSDFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 当前日历，这里用中国时间表示
     *
     * @return 以当地时区表示的系统当前日历
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 指定毫秒数表示的日历
     *
     * @param millis
     *            毫秒数
     * @return 指定毫秒数表示的日历
     */
    public static Calendar getCalendar(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(millis));
        return cal;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getDate
    // 各种方式获取的Date
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 当前日期
     *
     * @return 系统当前时间
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 指定毫秒数表示的日期
     *
     * @param millis
     *            毫秒数
     * @return 指定毫秒数表示的日期
     */
    public static Date getDate(long millis) {
        return new Date(millis);
    }

    /**
     * 时间戳转换为字符串
     *
     * @param time
     * @return
     */
    public static String timestamptoStr(Timestamp time) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }
        return date2Str(date_sdf);
    }

    /**
     * 字符串转换时间戳
     *
     * @param str
     * @return
     */
    public static Timestamp str2Timestamp(String str) {
        Date date = str2Date(str, date_sdf);
        return new Timestamp(date.getTime());
    }
    /**
     * 字符串转换成日期
     * @param str
     * @param sdf
     * @return
     */
    public static Date str2Date(String str, SimpleDateFormat sdf) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转换为字符串
     *
     * @return 字符串
     */
    public static String date2Str(SimpleDateFormat date_sdf) {
        Date date=getDate();
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }
    /**
     * 格式化时间
     * @param date
     * @param format
     * @return
     */
    public static String dateformat(String date,String format)
    {
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        Date _date=null;
        try {
            _date=sformat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sformat.format(_date);
    }
    /**
     * 日期转换为字符串
     *
     * @return 字符串
     */
    public static String date2Str(Date date, SimpleDateFormat date_sdf) {
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }
    /**
     * 日期转换为字符串
     *
     * @return 字符串
     */
    public static String getDate(String format) {
        Date date=new Date();
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 指定毫秒数的时间戳
     *
     * @param millis
     *            毫秒数
     * @return 指定毫秒数的时间戳
     */
    public static Timestamp getTimestamp(long millis) {
        return new Timestamp(millis);
    }

    /**
     * 以字符形式表示的时间戳
     *
     * @param time
     *            毫秒数
     * @return 以字符形式表示的时间戳
     */
    public static Timestamp getTimestamp(String time) {
        return new Timestamp(Long.parseLong(time));
    }

    /**
     * 系统当前的时间戳
     *
     * @return 系统当前的时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 指定日期的时间戳
     *
     * @param date
     *            指定日期
     * @return 指定日期的时间戳
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * 指定日历的时间戳
     *
     * @param cal
     *            指定日历
     * @return 指定日历的时间戳
     */
    public static Timestamp getCalendarTimestamp(Calendar cal) {
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp gettimestamp() {
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(dt);
        java.sql.Timestamp buydate = java.sql.Timestamp.valueOf(nowTime);
        return buydate;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getMillis
    // 各种方式获取的Millis
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 系统时间的毫秒数
     *
     * @return 系统时间的毫秒数
     */
    public static long getMillis() {
        return new Date().getTime();
    }

    /**
     * 指定日历的毫秒数
     *
     * @param cal
     *            指定日历
     * @return 指定日历的毫秒数
     */
    public static long getMillis(Calendar cal) {
        return cal.getTime().getTime();
    }

    /**
     * 指定日期的毫秒数
     *
     * @param date
     *            指定日期
     * @return 指定日期的毫秒数
     */
    public static long getMillis(Date date) {
        return date.getTime();
    }

    /**
     * 指定时间戳的毫秒数
     *
     * @param ts
     *            指定时间戳
     * @return 指定时间戳的毫秒数
     */
    public static long getMillis(Timestamp ts) {
        return ts.getTime();
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatDate
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日
     *
     * @return 默认日期按“年-月-日“格式显示
     */
    public static String formatDate() {
        return date_sdf.format(getCalendar().getTime());
    }

    /**
     * 默认方式表示的系统当前日期，具体格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 默认日期按“yyyy-MM-dd HH:mm:ss“格式显示
     */
    public static String formatDateTime() {
        return datetimeFormat.format(getCalendar().getTime());
    }
    /**
     * 获取时间字符串
     */
    public static String getDataString(SimpleDateFormat formatstr) {
        return formatstr.format(getCalendar().getTime());
    }
    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param cal
     *            指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Calendar cal) {
        return date_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param date
     *            指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Date date) {
        return date_sdf.format(date);
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日
     *
     * @param millis
     *            指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日“格式显示
     */
    public static String formatDate(long millis) {
        return date_sdf.format(new Date(millis));
    }

    /**
     * 默认日期按指定格式显示
     *
     * @param pattern
     *            指定的格式
     * @return 默认日期按指定格式显示
     */
    public static String formatDate(String pattern) {
        return getSDFormat(pattern).format(getCalendar().getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param cal
     *            指定的日期
     * @param pattern
     *            指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Calendar cal, String pattern) {
        return getSDFormat(pattern).format(cal.getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param date
     *            指定的日期
     * @param pattern
     *            指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Date date, String pattern) {
        return getSDFormat(pattern).format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日 时：分
     *
     * @return 默认日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime() {
        return time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param millis
     *            指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(long millis) {
        return time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param cal
     *            指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Calendar cal) {
        return time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param date
     *            指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Date date) {
        return time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatShortTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：时：分
     *
     * @return 默认日期按“时：分“格式显示
     */
    public static String formatShortTime() {
        return short_time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：时：分
     *
     * @param millis
     *            指定的毫秒数
     * @return 指定毫秒数表示日期按“时：分“格式显示
     */
    public static String formatShortTime(long millis) {
        return short_time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param cal
     *            指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Calendar cal) {
        return short_time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param date
     *            指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Date date) {
        return short_time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // parseDate
    // parseCalendar
    // parseTimestamp
    // 将字符串按照一定的格式转化为日期或时间
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src
     *            将要转换的原始字符窜
     * @param pattern
     *            转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Date parseDate(String src, String pattern)
            throws ParseException {
        return getSDFormat(pattern).parse(src);

    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src
     *            将要转换的原始字符窜
     * @param pattern
     *            转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Calendar parseCalendar(String src, String pattern)
            throws ParseException {

        Date date = parseDate(src, pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String formatAddDate(String src, String pattern, int amount)
            throws ParseException {
        Calendar cal;
        cal = parseCalendar(src, pattern);
        cal.add(Calendar.DATE, amount);
        return formatDate(cal);
    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src
     *            将要转换的原始字符窜
     * @param pattern
     *            转换的匹配格式
     * @return 如果转换成功则返回转换后的时间戳
     */
    public static Timestamp parseTimestamp(String src, String pattern)
            throws ParseException {
        Date date = parseDate(src, pattern);
        return new Timestamp(date.getTime());
    }

    // ////////////////////////////////////////////////////////////////////////////
    // dateDiff
    // 计算两个日期之间的差值
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 计算两个时间之间的差值，根据标志的不同而不同
     *
     * @param flag
     *            计算标志，表示按照年/月/日/时/分/秒等计算
     * @param calSrc
     *            减数
     * @param calDes
     *            被减数
     * @return 两个日期之间的差值
     */
    public static int dateDiff(char flag, Calendar calSrc, Calendar calDes) {

        long millisDiff = getMillis(calSrc) - getMillis(calDes);

        if (flag == 'y') {
            return (calSrc.get(Calendar.YEAR) - calDes.get(Calendar.YEAR));
        }

        if (flag == 'd') {
            return (int) (millisDiff / DAY_IN_MILLIS);
        }

        if (flag == 'h') {
            return (int) (millisDiff / HOUR_IN_MILLIS);
        }

        if (flag == 'm') {
            return (int) (millisDiff / MINUTE_IN_MILLIS);
        }

        if (flag == 's') {
            return (int) (millisDiff / SECOND_IN_MILLIS);
        }

        return 0;
    }


    /**
     * 判断是否为闰年
     *
     */
    public static boolean isLeapYear(int year) {
        boolean leap = false;
        leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        return leap;

    }

    /**
     * 判断是大月小月
     *
     */
    public static boolean isBigMonth(String nowMonth) {
        return !"04".equals(nowMonth) && !"06".equals(nowMonth) && !"09".equals(nowMonth) && !"11".equals(nowMonth);
    }


    /**
     * 获取下一个时间点
     */
    public static String getLastTime(String date) {
        String dateYear = date.substring(0,4);
        String dateMonth = date.substring(4,6);
        String dateDay = date.substring(6,8);
        String dateTime = date.substring(8,10);
        int futureYear,futureMonth,futureDay,futureTime;
        String lastTime = "";
        if(Integer.parseInt(dateTime)+1 == 24 ){
            //闰年2月
            if(isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if("29".equals(dateDay)){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = 0;

                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1;
                    futureTime = 0;

                }

            }

            //平年2月
            if(!isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if("28".equals(dateDay)){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = 0;

                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1;
                    futureTime = 0;
                }
            }

            //大小月
            if (isBigMonth(dateMonth)){
                if("12".equals(dateMonth)){
                    if("31".equals(dateDay)){
                        futureYear = Integer.parseInt(dateYear)+1;
                        futureMonth = 1;
                        futureDay = 1;
                        futureTime = 0;

                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+1;
                        futureTime = 0;
                    }
                }else{
                    if("31".equals(dateDay)){
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth)+1;
                        futureDay = 1;
                        futureTime = 0;

                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+1;
                        futureTime = 0;
                    }
                }
            }else{
                if("30".equals(dateDay)){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = 0;

                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1;
                    futureTime = 0;
                }
            }

        }else{
            futureYear = Integer.parseInt(dateYear);
            futureMonth = Integer.parseInt(dateMonth);
            futureDay = Integer.parseInt(dateDay);
            futureTime = Integer.parseInt(dateTime) + 1;
        }

        lastTime = String.valueOf(futureYear) + StringUtil.intToStr(futureMonth) + StringUtil.intToStr(futureDay)
                + StringUtil.intToStr(futureTime);

        return lastTime;

    }


    /**
     * 依次获取下一个时间点
     */
    public static String getLastTimeByIndex(String date,int index) {
        String dateYear = date.substring(0,4);
        String dateMonth = date.substring(4,6);
        String dateDay = date.substring(6,8);
        String dateTime = date.substring(8,10);
        int futureYear,futureMonth,futureDay,futureTime;
        String lastTime = "";
        int x = index / 24;//整数
        int y = index % 24;//余数
        if(Integer.parseInt(dateTime) + y >= 24 ){
            //闰年2月
            if(isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if(Integer.parseInt(dateDay)+x == 29){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else if(Integer.parseInt(dateDay)+x > 29){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x - 29 + 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1+x;
                    futureTime = 0+y;
                }

            }

            //平年2月
            if(!isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if(Integer.parseInt(dateDay)+x == 28){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else if(Integer.parseInt(dateDay)+x > 28){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x - 28 + 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1+x;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }
            }

            //大小月
            if (isBigMonth(dateMonth)){
                if("12".equals(dateMonth)){
                    if(Integer.parseInt(dateDay)+x == 31){
                        futureYear = Integer.parseInt(dateYear)+1;
                        futureMonth = 1;
                        futureDay = 1;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }else if(Integer.parseInt(dateDay)+x > 31){
                        futureYear = Integer.parseInt(dateYear)+1;
                        futureMonth = 1;
                        futureDay = Integer.parseInt(dateDay)+x - 31 + 1;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+1+x;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }
                }else{
                    if(Integer.parseInt(dateDay)+x == 31){
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth)+1;
                        futureDay = 1;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }else if(Integer.parseInt(dateDay)+x > 31){
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth)+1;
                        futureDay = Integer.parseInt(dateDay)+x - 31 + 1;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+1+x;
                        futureTime = Integer.parseInt(dateTime) + y - 24;
                    }
                }
            }else{
                if(Integer.parseInt(dateDay)+x == 30){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else if(Integer.parseInt(dateDay)+x > 30){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x - 30 + 1;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+1+x;
                    futureTime = Integer.parseInt(dateTime) + y - 24;
                }

            }

        }else{//到不了24点
            //闰年2月
            if(isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if(Integer.parseInt(dateDay)+x > 29){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x - 29;
                    futureTime = Integer.parseInt(dateTime)+y;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+x;
                    futureTime = Integer.parseInt(dateTime)+y;
                }

            }

            //平年2月
            if(!isLeapYear(Integer.parseInt(date)) && "02".equals(dateMonth)){
                if(Integer.parseInt(dateDay)+x > 28){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x - 28;
                    futureTime = Integer.parseInt(dateTime)+y;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+x;
                    futureTime = Integer.parseInt(dateTime)+y;
                }
            }

            //大小月
            if (isBigMonth(dateMonth)){
                if("12".equals(dateMonth)){
                    if(Integer.parseInt(dateDay)+x > 31){
                        futureYear = Integer.parseInt(dateYear)+1;
                        futureMonth = 1;
                        futureDay = Integer.parseInt(dateDay)+x -31;
                        futureTime = Integer.parseInt(dateTime)+y;
                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+x;
                        futureTime = Integer.parseInt(dateTime)+y;
                    }
                }else{
                    if(Integer.parseInt(dateDay)+x > 31){
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth)+1;
                        futureDay = Integer.parseInt(dateDay)+x -31;
                        futureTime = Integer.parseInt(dateTime)+y;
                    }else{
                        futureYear = Integer.parseInt(dateYear);
                        futureMonth = Integer.parseInt(dateMonth);
                        futureDay = Integer.parseInt(dateDay)+x;
                        futureTime = Integer.parseInt(dateTime)+y;
                    }
                }
            }else{
                if(Integer.parseInt(dateDay)+x > 30){
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth)+1;
                    futureDay = Integer.parseInt(dateDay)+x -30;
                    futureTime = Integer.parseInt(dateTime)+y;
                }else{
                    futureYear = Integer.parseInt(dateYear);
                    futureMonth = Integer.parseInt(dateMonth);
                    futureDay = Integer.parseInt(dateDay)+x;
                    futureTime = Integer.parseInt(dateTime)+y;
                }
            }
        }

        lastTime = String.valueOf(futureYear) + StringUtil.intToStr(futureMonth) + StringUtil.intToStr(futureDay)
                + StringUtil.intToStr(futureTime);

        return lastTime;

    }


    /**
     * 未来48小时的时间点
     *
     */
    public static String futureTwoDay() {
        String nowTime = TimeUtil.date2Str(TimeUtil.yyyyMMddHH);
        String nowYear = nowTime.substring(0,4);
        String nowMonth = nowTime.substring(4,6);
        String nowDay = nowTime.substring(6,8);
        String nowT = nowTime.substring(8,10);
        int futureYear,futureMonth,futureDay,futureTime;
        String futureDate = "";

        //闰年2月
        if(isLeapYear(Integer.parseInt(nowTime)) && "02".equals(nowMonth)){
            if(Integer.parseInt(nowDay) + 2 > 29){
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth) + 1;
                futureDay = Integer.parseInt(nowDay) + 2 - 29;
                futureTime = Integer.parseInt(nowT);

            }else {
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth);
                futureDay = Integer.parseInt(nowDay) + 2;
                futureTime = Integer.parseInt(nowT);
            }
        }

        //平年2月
        if(!isLeapYear(Integer.parseInt(nowTime)) && "02".equals(nowMonth)){
            if(Integer.parseInt(nowDay) + 2 > 28){
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth) + 1;
                futureDay = Integer.parseInt(nowDay) + 2 - 28;
                futureTime = Integer.parseInt(nowT);

            }else {
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth);
                futureDay = Integer.parseInt(nowDay) + 2;
                futureTime = Integer.parseInt(nowT);
            }
        }

        //大小月
        if (isBigMonth(nowMonth)){
            if(Integer.parseInt(nowDay) + 2 > 31){
                if("12".equals(nowMonth)){
                    futureYear = Integer.parseInt(nowYear)+ 1;
                    futureMonth = 1;
                    futureDay = Integer.parseInt(nowDay) + 2 - 31;
                    futureTime = Integer.parseInt(nowT);

                }else{
                    futureYear = Integer.parseInt(nowYear);
                    futureMonth = Integer.parseInt(nowMonth) + 1;
                    futureDay = Integer.parseInt(nowDay) + 2 - 31;
                    futureTime = Integer.parseInt(nowT);

                }


            }else {
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth);
                futureDay = Integer.parseInt(nowDay) + 2;
                futureTime = Integer.parseInt(nowT);
            }

        }else{
            if(Integer.parseInt(nowDay) + 2 > 30){
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth) + 1;
                futureDay = Integer.parseInt(nowDay) + 2 - 30;
                futureTime = Integer.parseInt(nowT);

            }else {
                futureYear = Integer.parseInt(nowYear);
                futureMonth = Integer.parseInt(nowMonth);
                futureDay = Integer.parseInt(nowDay) + 2;
                futureTime = Integer.parseInt(nowT);
            }
        }

        futureDate = String.valueOf(futureYear) + StringUtil.intToStr(futureMonth) + StringUtil.intToStr(futureDay)
                + StringUtil.intToStr(futureTime);

        return futureDate;

    }

    public static String  getYeartoday(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);

        return dateString;
    }

    public static String  getTomorrow(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);

        return dateString;
    }

    public static String  getAfterTomorrow(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,2);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);

        return dateString;
    }


    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result = format.format(today);
        return result;
    }

    /**
     * 获取未来 第 past 年
     * @param past
     * @return
     */
    public static String getFetureYear(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String result = format.format(today);
        return result;
    }

}
