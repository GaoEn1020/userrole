package com.piesat.user.util;

import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by yangdong on 2018/04/20.
 *
 */
public class HttpRequestUtil {
    static boolean proxySet = false;
    static String proxyHost = "127.0.0.1";
    static int proxyPort = 8087;
    /**
     * 编码 
     * @param source
     * @return
     */
    public static String urlEncode(String source,String encode) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source,encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }
    public static String urlEncodeGBK(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }
    /**
     * 发起http请求获取返回结果 
     * @param req_url 请求地址 
     * @return
     */
    public static String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源  
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return buffer.toString();
    }

    /**
     * 发送http请求取得返回的输入流 
     * @param requestUrl 请求地址 
     * @return InputStream
     */
    public static InputStream httpRequestIO(String requestUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // 获得返回的输入流  
            inputStream = httpUrlConn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }


    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param isproxy
     *               是否使用代理模式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param,boolean isproxy) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            if(isproxy){//使用代理模式
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }else{
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 打开和URL之间的连接

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");    // POST方法


            // 设置通用的请求属性

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.connect();

            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    private static String returnLastTime(String futureDate,String nowDate){
        if(futureDate.equals(TimeUtil.getLastTime(nowDate))){
            return  TimeUtil.getLastTime(nowDate);
        }else{
            return returnLastTime(futureDate,TimeUtil.getLastTime(nowDate));
        }
    }

    public static void main(String[] args) {
        //demo:代理访问
        /*String url = "http://211.154.196.243:3002/LY_api";
        String para = "time=2018042014&lat=39.875&lon=119.480";

        String sr=HttpRequestUtil.sendGet(url,para);
        System.out.println(sr);*/

        insertMapJoinData();
    }

    private static void insertMapJoinData() {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://192.168.1.73:3306/fengjing?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "root";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            con.setAutoCommit(false);

           /* FileReader reader = new FileReader("D:/LJMS/trunk/ljms/WebRoot/jbdata/100TUHAO.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);*/
            String line =null;
            int num = 0;



            //2.创建statement类对象，用来执行SQL语句！！
            String sql = "insert into weather_grid values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            double lon = 73.31;
            double lat = 18.00;
            java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");

            for(int i=300; i<1252; i++){
                double lonVa = lon + 0.05*i;
                for(int j=0; j<735; j++){
                    double latVa = lat + 0.05*j;
                    BigDecimal lonB = new BigDecimal(lonVa);
                    BigDecimal latB = new BigDecimal(latVa);
                    pst.setString(1, UUIDUtil.getUUID());
                    pst.setDouble(2, lonB.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    pst.setDouble(3, latB.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    pst.addBatch();

                    num++;
                    if (num==1000) {
                        pst.executeBatch();
                        con.commit();
                        num = 0;
                    }

                }

            }
            pst.executeBatch();
            con.commit();

            /*while(true){
                line = bufferedReader.readLine();
                if(line == null){
                    pst.executeBatch();
                    con.commit();
                    num = 0;
                    break;
                }

                pst.setString(1, UUIDUtil.getUUID());
                pst.setDouble(2, lonVa);
                pst.setDouble(3, latVa);

                num++;
                if (num==1000) {
                    pst.executeBatch();
                    con.commit();
                    num = 0;
                }

            }*/
            pst.close();
            con.close();

        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }


}