package com.piesat.user.util;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *@author yangdong
 *@description FTP工具类
 *@createDate 2018年4月11日
 **/
public class FtpUtil {


    /**
     * @description FTP登陆
     * @return ftpClient
     * @throws IOException
     * @throws SocketException
     **/
    private static FTPClient login(Map<String,String> maps) throws IOException{
        String ip=maps.get("ip");
        int ipPort=Integer.parseInt(maps.get("ipPort"));
        String userName=maps.get("userName");
        String passWord=maps.get("passWord");

        FTPClient ftpClient =new FTPClient();
        ftpClient.connect(ip, ipPort);
        ftpClient.login(userName, passWord);

        return ftpClient;
    }

    /**
     * @description FTP退出
     * @param  ftpClient   FTP对象
     * @throws IOException
     **/
    private static  void logout(FTPClient ftpClient) throws IOException{

        ftpClient.logout();

    }

    /**
     * @description 读取FTP文件
     * @param  caltlog          目录名称
     * @param  fileEndName      文件后缀名称
     * @param  fileContainsName 文件包含名称
     * @return list             目录内文件名称集合
     * @throws IOException
     **/
    public static  List<String> readFtpFile(String caltlog,String fileEndName,String fileContainsName,Map<String,String> maps) throws IOException{

        FTPClient ftpClient=login(maps);//登陆

        List<String> list=new ArrayList<String>();

        ftpClient.setControlEncoding("UTF-8");//字符集支持

        FTPFile[] files = ftpClient.listFiles(caltlog);

        for (int i = 0; i < files.length; i++) {
            if(files[i].getName().contains(fileEndName)){
                if(fileContainsName!=null){
                    if(files[i].getName().contains(fileContainsName)){
                        list.add(files[i].getName());
                    }
                }else{
                    list.add(files[i].getName());
                }
            }
        }

        logout(ftpClient);//退出
        return list;
    }

    /**
     * @description 下载FTP文件
     * @param  filePath    文件目录
     * @param  fileName    文件名称
     * @param  downloadUrl 下载本地目录地址
     * @throws IOException
     **/
    public static void downloadFtpFile(String filePath,String fileName,String downloadUrl,Map<String,String> maps) throws IOException{

        File file = new File(downloadUrl);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream  fos =new FileOutputStream(file+"/"+fileName);

        FTPClient ftpClient=login(maps);//登陆
        ftpClient.setBufferSize(1024);//流大小
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//二进制
        ftpClient.enterLocalPassiveMode();

        boolean flag=ftpClient.retrieveFile("/"+filePath+"/"+fileName, fos);
        fos.close();
        logout(ftpClient);//退出
    }


    /**
     * @description 上传FTP文件
     * @param  fileName    文件名称
     * @param  filePath    文件目录
     * @param  uploadUrl   上传文件本地目录地址
     * @throws IOException
     **/
    public static void uploadFtpFile(String fileName,String filePath,String uploadUrl,Map<String,String> maps) throws IOException{

        File file=null;
        if(uploadUrl.endsWith(File.separator)){
            file=new File(uploadUrl+fileName);
        }else{
            file=new File(uploadUrl+File.separator+fileName);
        }

        FileInputStream  fis =new FileInputStream(file);

        FTPClient ftpClient=login(maps);//登陆
        ftpClient.setBufferSize(1024);//流大小
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//二进制

        ftpClient.changeWorkingDirectory(filePath);
        ftpClient.storeFile(fileName, fis);
        fis.close();
        logout(ftpClient);//退出
    }


    /**
     * @description 删除FTP文件
     * @param  remoteFile  文件名称&目录
     * @param  maps        FTP登录信息
     * @throws SocketException、 IOException
     **/
    public static void deleFTPFile(String remoteFile,Map<String,String> maps) throws IOException{

        FTPClient ftpClient=login(maps);//登陆

        ftpClient.deleteFile(remoteFile);

        logout(ftpClient);//退出
    }




}
