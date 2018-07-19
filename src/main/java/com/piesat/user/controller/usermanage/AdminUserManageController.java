package com.piesat.user.controller.usermanage;


import com.piesat.user.pojo.result.ResultModelNew;
import com.piesat.user.pojo.result.ResultToolsNew;
import com.piesat.user.pojo.usercenter.ManageUserInfo;
import com.piesat.user.pojo.usercenter.RoleUser;
import com.piesat.user.service.userservice.AdminUserManageService;
import com.piesat.user.service.userservice.RoleRelationService;
import com.piesat.user.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
@RequestMapping(value = "/fengjing/adminUserManage")
public class AdminUserManageController {

    @Autowired
    private AdminUserManageService adminUserManageService;

    @Autowired
    private RoleRelationService roleRelationService;

    /**
     * 管理员的添加
     * @param map
     * @return
     */
    @RequestMapping("/addAdmin")
    public ResultModelNew addAdmin(@RequestBody Map<String,String> map){
        try{
            //角色编号
            String roleId=null;

            String manageUserName=null;
            String manageUserPhone=null;
            String manageUserTime=null;
            String manageUserDepart=null;
            String manageUserPassWord=null;
            String manageUserSex=null;
            String manageUserNumber=null;
            String manageUserAddress=null;
            String manageUserMail=null;
            String manageUserWechat=null;
            String manageUserRealName=null;
            if(map.containsKey("manageUserName") && map.containsKey("manageUserPhone") && map.containsKey("manageUserTime")
                    && map.containsKey("manageUserDepart") && map.containsKey("manageUserPassWord")
                    && map.containsKey("manageUserSex") && map.containsKey("manageUserNumber")
                    && map.containsKey("manageUserAddress") && map.containsKey("manageUserMail")
                    && map.containsKey("manageUserWechat") && map.containsKey("roleId")
                    && map.containsKey("manageUserRealName")){
                manageUserName=map.get("manageUserName").toString();
                manageUserPhone=map.get("manageUserPhone").toString();
                manageUserTime=map.get("manageUserTime").toString();
                manageUserDepart=map.get("manageUserDepart").toString();
                manageUserPassWord=map.get("manageUserPassWord").toString();
                manageUserSex=map.get("manageUserSex").toString();
                manageUserNumber=map.get("manageUserNumber").toString();
                manageUserAddress=map.get("manageUserAddress").toString();
                manageUserMail=map.get("manageUserMail").toString();
                manageUserWechat=map.get("manageUserWechat").toString();
                roleId=map.get("roleId").toString();
                manageUserRealName=map.get("manageUserRealName").toString();
                if(StrUtil.isNotNull(manageUserName) && StrUtil.isNotNull(manageUserPhone)
                        && StrUtil.isNotNull(manageUserTime) && StrUtil.isNotNull(manageUserDepart)
                        && StrUtil.isNotNull(manageUserPassWord) && StrUtil.isNotNull(manageUserSex)
                        && StrUtil.isNotNull(manageUserNumber) && StrUtil.isNotNull(manageUserAddress)
                        && StrUtil.isNotNull(manageUserMail) && StrUtil.isNotNull(manageUserWechat)
                        && StrUtil.isNotNull(manageUserRealName)){
                    if(!ValidateUtil.checkMobile(manageUserPhone) && StrUtil.isNotNull(roleId)){
                        return ResultToolsNew.result(false,"手机号格式错误","");
                    }

                    // 查询数据库验证该手机号是否有效
                    ManageUserInfo manageUIn = adminUserManageService.findByAdminUserPhone(manageUserPhone.trim());
                    if(manageUIn!=null){
                        return ResultToolsNew.result(false,"该手机号已经注册，请重新输入手机号","");
                    }

                    if(!ValidateUtil.checkEmail(manageUserMail)){
                        return ResultToolsNew.result(false,"邮箱格式错误","");
                    }
//                    if(!ValidateUtil.checkAdress(manageUserAddress)){
//                        return ResultToolsNew.result(false,"地址格式错误","");
//                    }
                    if(!ValidateUtil.checkDate(manageUserTime)){
                        return ResultToolsNew.result(false,"日期格式错误","");
                    }
//                    if(!ValidateUtil.checkName(manageUserName)){
//                        return ResultToolsNew.result(false,"姓名格式错误","");
//                    }

                    int user=adminUserManageService.findByName(manageUserName);
                    if(user!=-1){
                        return ResultToolsNew.result(false,"该登录名已被占用","");
                    }


                    ManageUserInfo manageUserInfo=new ManageUserInfo();
                    manageUserInfo.setManageUserAddress(manageUserAddress);
                    manageUserInfo.setManageUserDepart(manageUserDepart);
                    manageUserInfo.setManageUserMail(manageUserMail);
                    manageUserInfo.setManageUserName(manageUserName);
                    manageUserInfo.setManageUserNumber(manageUserNumber);
                    manageUserInfo.setManageUserPassWord(manageUserPassWord);
                    manageUserInfo.setManageUserPhone(manageUserPhone);
                    manageUserInfo.setManageUserSex(Integer.parseInt(manageUserSex));
                    manageUserInfo.setManageUserTime(TimeUtil.str2Date(manageUserTime,TimeUtil.date_sdf));
                    manageUserInfo.setManageUserWechat(manageUserWechat);
                    manageUserInfo.setManageUserRealName(manageUserRealName);

                    String manageUserNameNums=adminUserManageService.queryByManageUserId();
                    String manageUserNameId=String.format("%010d", Integer.parseInt(manageUserNameNums)+1);//补位为10位
                    manageUserInfo.setManageUserNameId(manageUserNameId);

                    //进行数据的添加
                    manageUserInfo.setManageUserId(UUIDUtil.getUUID());
                    boolean flag=adminUserManageService.addAdmin(manageUserInfo,roleId);
                    if(flag){
                        return ResultToolsNew.result(true,"","添加成功");
                    }else {
                        return ResultToolsNew.result(true,"","添加失败");
                    }

                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }

            }else{
                return ResultToolsNew.result(false,"参数格式不正确","");
            }

        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 管理员的修改
     * @param map
     * @return
     */
    @RequestMapping("/modifyAdmin")
    public ResultModelNew modifyAdmin(@RequestBody Map<String,String> map){
        try{
            String roleId=null;

            String manageUserId=null;
            String manageUserName=null;
            String manageUserPhone=null;
            String manageUserDepart=null;
            String manageUserSex=null;
            String manageUserNumber=null;
            String manageUserAddress=null;
            String manageUserMail=null;
            String manageUserPassWord=null;
            String manageUserWechat=null;
            String manageUserRealName=null;
            if(map.containsKey("manageUserName")
                    && map.containsKey("manageUserPhone")
                    && map.containsKey("manageUserId")
                    && map.containsKey("manageUserDepart")  && map.containsKey("manageUserSex")
                    && map.containsKey("manageUserNumber") && map.containsKey("manageUserAddress")
                    && map.containsKey("manageUserMail") && map.containsKey("manageUserWechat")
                    && map.containsKey("roleId")
                    && map.containsKey("manageUserPassWord")
                    && map.containsKey("manageUserRealName")){
                manageUserId=map.get("manageUserId").toString();
                manageUserName=map.get("manageUserName").toString();
                manageUserPhone=map.get("manageUserPhone").toString();
                manageUserDepart=map.get("manageUserDepart").toString();
                manageUserSex=map.get("manageUserSex").toString();
                manageUserNumber=map.get("manageUserNumber").toString();
                manageUserAddress=map.get("manageUserAddress").toString();
                manageUserMail=map.get("manageUserMail").toString();
                manageUserWechat=map.get("manageUserWechat").toString();
                manageUserPassWord=map.get("manageUserPassWord").toString();
                roleId=map.get("roleId").toString();
                manageUserRealName=map.get("manageUserRealName").toString();
                if(StrUtil.isNotNull(manageUserName)
                        && StrUtil.isNotNull(manageUserPhone)
                        && StrUtil.isNotNull(manageUserId) && StrUtil.isNotNull(manageUserDepart)
                        && StrUtil.isNotNull(manageUserSex) && StrUtil.isNotNull(manageUserNumber)
                        && StrUtil.isNotNull(manageUserAddress) && StrUtil.isNotNull(manageUserMail)
                        && StrUtil.isNotNull(manageUserWechat) && StrUtil.isNotNull(roleId)
                        && StrUtil.isNotNull(manageUserPassWord) && StrUtil.isNotNull(manageUserRealName)){
                    if(!ValidateUtil.checkMobile(manageUserPhone)){
                        return ResultToolsNew.result(false,"手机号格式错误","");
                    }
                    if(!ValidateUtil.checkEmail(manageUserMail)){
                        return ResultToolsNew.result(false,"邮箱格式错误","");
                    }
                    if(!ValidateUtil.checkAdress(manageUserAddress)){
                        return ResultToolsNew.result(false,"地址格式错误","");
                    }
//                    if(!ValidateUtil.checkName(manageUserName)){
//                        return ResultToolsNew.result(false,"姓名格式错误","");
//                    }


                    //进行查询管理员信息
                    ManageUserInfo manageUInfo=new ManageUserInfo();
                    manageUInfo.setManageUserId(manageUserId);
                    manageUInfo.setManageUserStatus("1");
                    List<ManageUserInfo> manageUserInfos=adminUserManageService.queryAdminUser(manageUInfo);
                    if(manageUserInfos.size()<=0){
                        return ResultToolsNew.result(false,"该用户编号出错或该用户已经注销","");
                    }
                    if(manageUserName.equals(manageUserInfos.get(0).getManageUserName())
                            && manageUserPhone.equals(manageUserInfos.get(0).getManageUserPhone())
                            && manageUserDepart.equals(manageUserInfos.get(0).getManageUserDepart())
                            && Integer.parseInt(manageUserSex)== manageUserInfos.get(0).getManageUserSex()
                            && manageUserNumber.equals(manageUserInfos.get(0).getManageUserNumber())
                            && manageUserAddress.equals(manageUserInfos.get(0).getManageUserAddress())
                            && manageUserMail.equals(manageUserInfos.get(0).getManageUserMail())
                            && manageUserWechat.equals(manageUserInfos.get(0).getManageUserWechat())
                            && roleId.equals(manageUserInfos.get(0).getRoleId())
                            && manageUserRealName.equals(manageUserInfos.get(0).getManageUserRealName())
                            && manageUserPassWord.equals(manageUserInfos.get(0).getManageUserPassWord())){
                        return ResultToolsNew.result(true,"用户需修改的信息与原信息一致无需修改","");
                    }else {
                        if(!manageUserName.equals(manageUserInfos.get(0).getManageUserName())){
                            int user=adminUserManageService.findByName(manageUserName);
                            if(user!=-1){
                                return ResultToolsNew.result(false,"该登录名已被占用","");
                            }
                        }
                        ManageUserInfo manageUserInfo=new ManageUserInfo();
                        manageUserInfo.setManageUserAddress(manageUserAddress);
                        manageUserInfo.setManageUserDepart(manageUserDepart);
                        manageUserInfo.setManageUserMail(manageUserMail);
                        manageUserInfo.setManageUserName(manageUserName);
                        manageUserInfo.setManageUserNumber(manageUserNumber);
                        manageUserInfo.setManageUserId(manageUserId);
                        manageUserInfo.setManageUserPhone(manageUserPhone);
                        manageUserInfo.setManageUserSex(Integer.parseInt(manageUserSex));
                        manageUserInfo.setManageUserWechat(manageUserWechat);
                        manageUserInfo.setManageUserPassWord(manageUserPassWord);
                        manageUserInfo.setManageUserRealName(manageUserRealName);
                        boolean flag=adminUserManageService.modifyAdmin(manageUserInfo,roleId);
                        if(flag){
                            return ResultToolsNew.result(true,"","修改成功");
                        }else {
                            return ResultToolsNew.result(true,"","修改失败");
                        }
                    }

                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }

            }else{
                return ResultToolsNew.result(false,"参数格式不正确","");
            }

        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 将已注销的管理员解开，可以正常使用
     * @param map
     * @return
     */
    @RequestMapping("/modifyStatusAdmin")
    public ResultModelNew modifyStatusAdmin(@RequestBody Map<String,String> map){
        try{
            String manageUserId=null;
            if(map.containsKey("manageUserId")){
                manageUserId=map.get("manageUserId").toString();
                if(StrUtil.isNotNull(manageUserId)){

                    //进行查询管理员信息
                    ManageUserInfo manageUInfo=new ManageUserInfo();
                    manageUInfo.setManageUserId(manageUserId);
                    manageUInfo.setManageUserStatus("0");
                    List<ManageUserInfo> manageUserInfos=adminUserManageService.queryAdminUser(manageUInfo);
                    if(manageUserInfos.size()<=0){
                        return ResultToolsNew.result(false,"该用户编号出错或该用户编号不在已注销中","");
                    }
                    boolean flag=adminUserManageService.modifyStatusAdmin(manageUserId);
                    if(flag){
                        return ResultToolsNew.result(true,"","修改成功");
                    }else {
                        return ResultToolsNew.result(true,"","修改失败");
                    }

                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }

            }else{
                return ResultToolsNew.result(false,"参数格式不正确","");
            }

        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 管理员删除
     * @param map
     * @return
     */
    @RequestMapping("/deleteAdmin")
    public ResultModelNew deleteAdmin(@RequestBody Map<String,String> map){
        try{
            String manageUserId=null;
            if(map.containsKey("manageUserId")){
                manageUserId=map.get("manageUserId").toString();
                if(StrUtil.isNotNull(manageUserId)){
                    Boolean flag=adminUserManageService.deleteAdmin(manageUserId);
                    if (flag){
                        return ResultToolsNew.result(true,"","注销成功");
                    }else {
                        return ResultToolsNew.result(true,"","注销失败");
                    }
                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式错误","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 管理员查询（可查询正常的也可查询注销的）
     * @param map
     * @return
     */
    @RequestMapping("/queryAdminUser")
    public ResultModelNew queryAdminUser(@RequestBody Map<String,String> map){
        try{
            String manageUserId=null;
            String manageUserName=null;
            String manageUserNameId=null;
            String pageNo=null;
            String pageCount=null;
            String manageUserStatus="1";//1正常 0注销的   不写时为正常
            if(map.containsKey("manageUserNameId")){
                if(StrUtil.isNotNull(map.get("manageUserNameId").toString())){
                    manageUserNameId=map.get("manageUserNameId").toString();
                }
            }if(map.containsKey("manageUserId")){
                if(StrUtil.isNotNull(map.get("manageUserId").toString())){
                    manageUserId=map.get("manageUserId").toString();
                }
            }
            if(map.containsKey("manageUserName")){
                if(StrUtil.isNotNull(map.get("manageUserName").toString())){
                    manageUserName=map.get("manageUserName").toString();
                }
            }
            if(map.containsKey("manageUserStatus")){
                if(StrUtil.isNotNull(map.get("manageUserStatus").toString())){
                    manageUserStatus=map.get("manageUserStatus").toString();
                }
            }
            ManageUserInfo manageUserInfo=new ManageUserInfo();
            manageUserInfo.setManageUserId(manageUserId);
            manageUserInfo.setManageUserName(manageUserName);
            manageUserInfo.setManageUserNameId(manageUserNameId);
            manageUserInfo.setManageUserStatus(manageUserStatus);
            List<ManageUserInfo> manageUserInfos=adminUserManageService.queryAdminUser(manageUserInfo);
            if(manageUserId!=null){
                return ResultToolsNew.result(true,"",manageUserInfos);
            }else {
                if (map.containsKey("pageNo") && map.containsKey("pageCount")){
                    pageNo=map.get("pageNo").toString();
                    pageCount=map.get("pageCount").toString();
                    if(StrUtil.isNotNull(pageCount) && StrUtil.isNotNull(pageNo)){
                        List<ManageUserInfo> manageUserInfoList= PagingUtils.getPageInfo(manageUserInfos,Integer.parseInt(pageNo),Integer.parseInt(pageCount));
                        Map<String,Object> manageUserInfoMap=new HashMap<String, Object>();
                        manageUserInfoMap.put("sumCount",manageUserInfos.size());
                        manageUserInfoMap.put("manageUserInfos",manageUserInfoList);
                        return ResultToolsNew.result(true,"",manageUserInfoMap);
                    }else {
                        return ResultToolsNew.result(false, "分页参数不能为空", "");
                    }
                }else {
                    return ResultToolsNew.result(false,"分页参数格式不正确","");
                }
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     *用户登录
     * @param map
     * @return
     */
    @RequestMapping("/loginUserByName")
    public ResultModelNew loginUserByName(@RequestBody Map<String,String> map){
        try{
            String manageUserName=null;
            String manageUserPassWord=null;
            if(map.containsKey("manageUserName") && map.containsKey("manageUserPassWord")){
                manageUserName=map.get("manageUserName").toString();
                manageUserPassWord=map.get("manageUserPassWord").toString();
                if(StrUtil.isNotNull(manageUserName)){
                    ManageUserInfo manageUserInfo=new ManageUserInfo();
                    manageUserInfo.setManageUserName(manageUserName);
                    manageUserInfo.setManageUserStatus("1");
                    List<ManageUserInfo> manageUserInfos=adminUserManageService.queryAdminUser(manageUserInfo);
                    if(manageUserInfos.size()<=0){
                        return ResultToolsNew.result(false,"此用户名不存在","");
                    }
                    if(manageUserPassWord.equals(manageUserInfos.get(0).getManageUserPassWord())){
                        //查询权限
                        List<RoleUser> roleUsers=roleRelationService.queryByUserId(manageUserInfos.get(0).getManageUserId());
                        return ResultToolsNew.result(true,"",roleUsers);
                    }
                    return ResultToolsNew.result(false,"密码错误","");
                }else {
                    return ResultToolsNew.result(false, "参数不能为空", "");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 忘记密码
     *
     * @param map
     * @return
     */
    @RequestMapping("/forgetAdminPwd")
    public ResultModelNew forgetAdminPwd(@RequestBody Map<String,Object> map,HttpServletRequest request){
        try{

            String userPhone = null;
            String newPwd = null;
            String confirmPwd = null;
            String checkCode = null;
            ManageUserInfo manageUserInfo = null;

            if(map.containsKey("userPhone")){
                userPhone = map.get("userPhone").toString();

                if(!StrUtil.isNotNull(userPhone)){
                    return ResultToolsNew.result(false,"请输入手机号，不能为空","");
                }

                // 判断str是否为手机号
                String regex = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";

                int len = userPhone.trim().length();

                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(userPhone);
                boolean isMatch = m.matches();

                if(len!=11||!isMatch){
                    return ResultToolsNew.result(false,"手机号格式不正确","");
                }

                // 查询数据库验证该手机号是否有效
                manageUserInfo = adminUserManageService.findByAdminUserPhone(userPhone.trim());
                if(manageUserInfo==null){
                    return ResultToolsNew.result(false,"该手机号尚未绑定","");
                }

            }

            if(map.containsKey("checkCode")){
                checkCode= map.get("checkCode").toString();
                if(!StrUtil.isNotNull(checkCode)){
                    return ResultToolsNew.result(false,"验证码不能为空","");
                }
            }

            // 调取第三方短信接口传入手机号获取验证码
            String _checkCode ="23dx";
            if(!checkCode.trim() .equals(_checkCode.trim()) ){
                return ResultToolsNew.result(false,"验证码错误","");
            }


            if(map.containsKey("newPwd")){
                newPwd =map.get("newPwd").toString();

                if(!StrUtil.isNotNull(newPwd)){
                    return ResultToolsNew.result(false,"新密码不能为空","");
                }

                if(!PasswordValidUtil.validPwd(newPwd)){
                    return ResultToolsNew.result(false,"密码必须包含大小写字母且长度为6-12","");
                }


            }

            if(map.containsKey("confirmPwd")){
                confirmPwd =map.get("confirmPwd").toString();

                if(!newPwd.trim() .equals(confirmPwd.trim()) ){
                    return ResultToolsNew.result(false,"两次密码输入不一致","");
                }
            }

                String manageUserId = manageUserInfo.getManageUserId();
            // 重设密码
            int i = adminUserManageService.modifyAdminUserPassword(manageUserId, newPwd.trim());
            if(i==1){
                return ResultToolsNew.result(true,"","密码重置成功");
            }else{
                return ResultToolsNew.result(false,"密码重置失败","");
            }


        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

}
