package com.piesat.user.controller.usercenter;


import com.piesat.user.pojo.result.ResultModelNew;
import com.piesat.user.pojo.result.ResultToolsNew;
import com.piesat.user.pojo.usercenter.UserInfoCount;
import com.piesat.user.service.usercenter.UserInfoCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户信息统计的Controller类
 *
 * Created by zhaoxiaojun on 2018/04/30.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/fengjing/userinfocount")
public class UserInfoCountController {

    @Autowired
    private UserInfoCountService userInfoCountService;

    /**
     *个人中心统计展示
     */
    @RequestMapping(value = "/countUserInfo")
    public ResultModelNew countUserInfo(@RequestBody Map<String,String> map){
        try{
            String userId = null;
            UserInfoCount userInfoCount = new UserInfoCount();
            if (map.containsKey("userId")){
                userId = map.get("userId").toString();
            }
            if (userId!=null){
                if (userInfoCountService.queryUserLandCount(userId)!=null&&userInfoCountService.queryUserInfoCountAreaSum(userId)!=null&&
                        userInfoCountService.queryUserInfoCountMessageSum(userId)!=null&&userInfoCountService.queryUserInfoCountServe(userId)!=null){
                    userInfoCount.setUserInfoCountNumber(userInfoCountService.queryUserLandCount(userId));
                    userInfoCount.setUserInfoCountAreaSum(userInfoCountService.queryUserInfoCountAreaSum(userId));
                    userInfoCount.setUserInfoCountMessageSum(userInfoCountService.queryUserInfoCountMessageSum(userId));
                    userInfoCount.setUserInfoCountServe(userInfoCountService.queryUserInfoCountServe(userId));
                    return ResultToolsNew.result(true, "", userInfoCount);
                }else{
                    return ResultToolsNew.result(false,"未获取到相应内容","");
                }
            }else{
                return ResultToolsNew.result(false,"传入的用户ID为空","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }
}
