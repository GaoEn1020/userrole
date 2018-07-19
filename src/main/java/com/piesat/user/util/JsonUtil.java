package com.piesat.user.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public String ReadFile(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */

    public static List<String> readFileByLines(String fileName) {

        List<String> resultList = new ArrayList<String>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1  ;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if(line>1){
                    resultList.add(tempString);
                }
                //System.out.println("line " + line + ": " + tempString);
                line++;

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return resultList;

    }


    public static void main(String[] args) {
       /* try{
            new WeatherDataInsertController().weatherHistoryDataInsert("D:/output/20170101",".txt","/");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
