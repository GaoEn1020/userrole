package com.piesat.user.controller.usercenter;


import com.piesat.user.pojo.result.ResultModelNew;
import com.piesat.user.pojo.result.ResultToolsNew;
import com.piesat.user.pojo.usercenter.UserInfo;
import com.piesat.user.pojo.usercenter.UserMessage;
import com.piesat.user.pojo.usercenter.UserView;
import com.piesat.user.service.usercenter.UserInfoService;
import com.piesat.user.util.StrUtil;
import com.piesat.user.util.StringUtil;
import com.piesat.user.util.UUIDUtil;
import com.piesat.user.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户信息的Controller类
 *
 * Created by zhaoxiaojun on 2018/04/23.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/fengjing/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

//    @Autowired
//    private FarmLandInfoService farmLandInfoService;

    /**
     * 查询个人信息
     */
    @RequestMapping(value = "/queryUserInfo")
    public ResultModelNew queryUserInfo(@RequestBody Map<String,String> map){
        try{
            String userId = null;
            if (map.containsKey("userId")){
                userId = map.get("userId").toString();
            }
            if (userId!=null){
                UserInfo userInfo = userInfoService.queryUserInfo(userId);
                if (StringUtil.isNotEmpty(userInfo)){
                    /*if (userInfo.getUserStaus() == 1 && userInfo.getUserType() == 0){
                        UserInfo userInfoList = userInfoService.queryUserInfo(userId);
                        return ResultToolsNew.result(true, "", userInfoList);
                    }else{
                        return ResultToolsNew.result(false,"此用户已注销","");
                    }*/
                    return ResultToolsNew.result(true, "", userInfo);
                }else{
                    return ResultToolsNew.result(false,"未找到对应内容","");
                }
            }else{
                return ResultToolsNew.result(false,"传入的用户编号为空","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 修改个人信息
     */
    @RequestMapping(value = "/updateUserInfo")
    @ResponseBody
    public ResultModelNew updateUserInfo(@RequestBody UserInfo userInfo){
        try {
            if (userInfoService.isExist(userInfo.getUserId())) {
                if (userInfo.getUserRealname() != null && userInfo.getUserSex() != null && userInfo.getUserAddress() != null && userInfo.getUserMail() != null &&
                        userInfo.getUserNumber() != null && userInfo.getUserPhone() != null && userInfo.getUserWechat() != null) {
                    if (ValidateUtil.checkAdress(userInfo.getUserAddress()) == false) {
                        return ResultToolsNew.result(false, "用户地址录入不正确", "");
                    }
                    if (ValidateUtil.checkEmail(userInfo.getUserMail()) == false) {
                        return ResultToolsNew.result(false, "用户邮箱录入不正确", "");
                    }
                    if (ValidateUtil.checkMobile(userInfo.getUserPhone()) == false) {
                        return ResultToolsNew.result(false, "用户手机录入不正确", "");
                    }
                    if (ValidateUtil.checkName(userInfo.getUserRealname()) == false) {
                        return ResultToolsNew.result(false, "用户姓名录入不正确", "");
                    }
                    if (ValidateUtil.checkCard(userInfo.getUserNumber()) == false) {
                        return ResultToolsNew.result(false, "用户身份证录入不正确", "");
                    }
                    if (ValidateUtil.checkAll(userInfo.getUserWechat()) == false) {
                        return ResultToolsNew.result(false, "用户微信录入不正确", "");
                    }
                    List<UserInfo> userInfoList = userInfoService.queryUserInfoList();
                    if (userInfoList != null) {
                        for (UserInfo userInfos : userInfoList) {
                            if (userInfos.getUserWechat().equals(userInfo.getUserWechat()) && userInfos.getUserPhone().equals(userInfo.getUserPhone()) &&
                                    userInfos.getUserNumber().equals(userInfo.getUserNumber()) && userInfos.getUserMail().equals(userInfo.getUserMail())) {
                                return ResultToolsNew.result(true, "传入信息相同", "");
                            }
                        }
                        if (userInfo.getUserSex() >= 0 && userInfo.getUserSex() < 2) {
                            int num = userInfoService.updateUserInfo(userInfo);
                            if (num == 1) {
                                return ResultToolsNew.result(true, "", "修改成功");
                            } else {
                                return ResultToolsNew.result(false, "修改失败", "");
                            }
                        } else {
                            return ResultToolsNew.result(false, "年龄传参错误", "");
                        }
                    }else{
                        return ResultToolsNew.result(false, "数据库没有用户信息", "");
                    }
                } else {
                    return ResultToolsNew.result(false, "传入参数不可为空", "");
                }
            } else {
                return ResultToolsNew.result(false, "此用户不存在", "");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 个人中心消息展示
     */
    @RequestMapping(value = "/queryUserMessage")
    public ResultModelNew queryUserMessage(@RequestBody Map<String,String> map){
        try{
            String userId = null;
            if (map.containsKey("userId")){
                userId = map.get("userId").toString();
            }
            UserInfo usInfo = userInfoService.findStausAndType(userId);
            if (usInfo != null){
                if (userId != null && usInfo.getUserStaus()==1 && usInfo.getUserType() == 0){
                    List<UserMessage> userMessageList = userInfoService.queryUserMessage(userId);
                    if (userMessageList!=null){
                       /* Collections.sort(userMessageList, new Comparator<UserMessage>() {
                            @Override
                            public int compare(UserMessage o1, UserMessage o2) {
                                if (o1.getMessageSendTime().getTime()< o2.getMessageSendTime().getTime()){
                                    return 1;
                                }
                                if (o1.getMessageSendTime().getTime()==o2.getMessageSendTime().getTime()){
                                    return 0;
                                }
                                return -1;
                            }
                        });*/
                        return ResultToolsNew.result(true, "", userMessageList);
                    }else{
                        return ResultToolsNew.result(false,"未找到对应内容!","");
                    }
                }else{
                    return ResultToolsNew.result(false,"请求传参错误","");
                }
            }else{
                return ResultToolsNew.result(false,"未找到对应内容！","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 个人中心消息删除
     */
    @RequestMapping(value = "/deleteUserMessage")
    public ResultModelNew deleteUserMessage(@RequestBody Map<String,String> map){
        try{
            String userId = null;
            String messageId = null;
            if (map.containsKey("userId")){
                userId = map.get("userId").toString();
            }
            if (map.containsKey("messageId")){
                messageId = map.get("messageId").toString();
            }
            if (messageId != null) {
                boolean messageStaus = userInfoService.findUserMessageById(messageId);
                if (messageStaus == true&&userId != null){
                    boolean messageType = userInfoService.deleteUserMessage(userId,messageId);
                    if(messageType == true){
                        return ResultToolsNew.result(true,"","删除成功");
                    }else{
                        return ResultToolsNew.result(false,"删除失败","");
                    }
                }else{
                    return ResultToolsNew.result(false,"没有此消息！","");
                }
            }else{
                return ResultToolsNew.result(false,"消息编号为空！","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 个人中心消息的批量删除
     */
    @RequestMapping(value = "/deleteAllUserMessage")
    public ResultModelNew deleteAllUserMessage(@RequestBody Map<String,String> map){
        try{
            String userId = null;
            String messageIds = null;
            if (map.containsKey("userId")){
                userId = map.get("userId").toString();
            }
            if (map.containsKey("messageIds")){
                messageIds = map.get("messageIds").toString();
            }
            if (messageIds != null) {
                String[] listMessageId=messageIds.split(",");
                StringBuffer falseResult=new StringBuffer();
                for(String messageId:listMessageId){
                    boolean messageStaus = userInfoService.findUserMessageById(messageId);
                    if (messageStaus == true&&userId != null){
                        boolean messageType = userInfoService.deleteUserMessage(userId,messageId);
                        if(messageType == false){
                            falseResult.append(messageId+";");
                        }
                    }else{
                        return ResultToolsNew.result(false,"没有此消息！","");
                    }
                }
                if(StrUtil.isNotNull(falseResult)){
                    return ResultToolsNew.result(false,"消息编号为："+falseResult+"的消息删除失败","");
                }
                return ResultToolsNew.result(true,"","删除成功");
            }else{
                return ResultToolsNew.result(false,"消息编号为空！","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     *个人中心消息状态修改
     */
    @RequestMapping(value = "/updateUserMessage")
    public ResultModelNew updateUserMessage(@RequestBody Map<String,String> map){
        try{
            String messageId = null;
            String messageStaus = null;
            if (map.containsKey("messageId")){
                messageId = map.get("messageId").toString();
            }
            if (map.containsKey("messageStaus")){
                messageStaus = map.get("messageStaus").toString();
            }
            if (messageId != null){
                boolean msgStatus = userInfoService.findUserMessageById(messageId);
                if (msgStatus == true){
                    boolean messageStauss = userInfoService.updateUserMessage(messageId);
                    if (messageStauss == true) {
                        return ResultToolsNew.result(true,"","修改成功");
                    }
                    return ResultToolsNew.result(false,"修改失败","");
                }else{
                    return ResultToolsNew.result(false,"此消息不存在！","");
                }
            }else{
                return ResultToolsNew.result(false,"没有此消息！","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 消息提醒展示
     */
    @RequestMapping(value = "/queryUserMessageType")
    public ResultModelNew queryUserMessageType(@RequestBody Map<String,String> map) {
        try {
            String userId = null;
            if (map.containsKey("userId")) {
                userId = map.get("userId").toString();
            }
            UserInfo usInfo = userInfoService.findStausAndType(userId);
            if (usInfo != null) {
                if (userId != null && usInfo.getUserStaus() == 1 && usInfo.getUserType() == 0) {
                    List<UserMessage> list = new ArrayList<UserMessage>();
                    UserMessage messageContentZero = userInfoService.findUserMessageContentByZero(userId);
                    UserMessage messageContentOne = userInfoService.findUserMessageContentByOne(userId);
                    UserMessage messageContentTwo = userInfoService.findUserMessageContentByTwo(userId);
                    UserMessage messageContentThree = userInfoService.findUserMessageContentByThree(userId);
                    UserMessage messageContentFour = userInfoService.findUserMessageContentByFour(userId);

                    if(StringUtil.isNotEmpty(messageContentZero)){
                        list.add(messageContentZero);
                    }

                    if(StringUtil.isNotEmpty(messageContentOne)){
                        list.add(messageContentOne);
                    }

                    if(StringUtil.isNotEmpty(messageContentTwo)){
                        list.add(messageContentTwo);
                    }

                    if(StringUtil.isNotEmpty(messageContentThree)){
                        list.add(messageContentThree);
                    }

                    if(StringUtil.isNotEmpty(messageContentFour)){
                        list.add(messageContentFour);
                    }

                    if (messageContentZero == null && messageContentOne == null  && messageContentTwo == null
                            && messageContentThree == null && messageContentFour == null) {
                        return ResultToolsNew.result(false, "未查询到相应消息内容", "");
                    }
                    return ResultToolsNew.result(true, "", list);

                } else {
                    return ResultToolsNew.result(false, "参数为空或此用户已注销", "");
                }
            } else {
                return ResultToolsNew.result(false, "未找到对应内容！", "");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }


    /**
     * 客户意见
     */
    @RequestMapping(value = "/addUserView")
    public ResultModelNew addUserView(@RequestBody Map<String,String> map) {
        if (map.containsKey("userId") && map.containsKey("viewInfo")){
            UserView userView = new UserView();
            userView.setViewId(UUIDUtil.getUUID());
            userView.setUserId(map.get("userId").toString());
            userView.setViewInfo(map.get("viewInfo").toString());
            userView.setViewDate(new Date());
            boolean result = userInfoService.addUserView(userView);
            if(result){
                return ResultToolsNew.result(true, "客户意见添加成功", "");
            }else{
                return ResultToolsNew.result(false, "客户意见添加失败", "");
            }


        }else{
            return ResultToolsNew.result(false, "必须项缺失", "");
        }

    }

}
