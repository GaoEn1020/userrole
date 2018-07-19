package com.piesat.user.service.userservice;


import com.piesat.user.mapper.usermapper.AdminUserManageMapper;
import com.piesat.user.mapper.usermapper.RoleRelationMapper;
import com.piesat.user.pojo.usercenter.ManageUserInfo;
import com.piesat.user.pojo.usercenter.RoleUser;
import com.piesat.user.util.StrUtil;
import com.piesat.user.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Created by fanxiaodan on 2018/05/31
 */
@Service
@Transactional
public class AdminUserManageService {

    @Autowired
    private AdminUserManageMapper adminUserManageMapper;

    @Autowired
    private RoleRelationMapper roleRelationMapper;
    /**
     * 添加管理员信息
     * @return
     */
    public Boolean addAdmin(ManageUserInfo manageUserInfo, String roleId){
        boolean flag=adminUserManageMapper.addAdmin(manageUserInfo);
        //添加用户角色表
        RoleUser roleUser=new RoleUser();
        roleUser.setManageUserId(manageUserInfo.getManageUserId());
        roleUser.setRoleId(roleId);
        roleUser.setUserTRoleId(UUIDUtil.getUUID());
        boolean roleFlag=roleRelationMapper.addroleRelation(roleUser);
        return (flag && roleFlag);
    }
//    计算编号的后两位
    public String queryByManageUserId(){
        String result=adminUserManageMapper.queryByManageUserId();
        if(!StrUtil.isNotNull(result)){
            result="0";
        }
        return result;
    }
    /**
     * 通过用户名查询实体
     *
     * @param userName
     * @return
     */
    public int  findByName(String userName){

        // 调取用户数据访问层
        ManageUserInfo manageUserInfo = adminUserManageMapper.selectByName(userName);
        if(manageUserInfo != null){
            return 1;
        }
        return -1;

    }
    /**
     * 修改管理员信息
     * @param manageUserInfo
     * @return
     */
    public Boolean modifyAdmin(ManageUserInfo manageUserInfo,String roleId){
        boolean flag=adminUserManageMapper.modifyAdmin(manageUserInfo);
        //修改用户角色表
        RoleUser roleUser=new RoleUser();
        roleUser.setManageUserId(manageUserInfo.getManageUserId());
        roleUser.setRoleId(roleId);
        boolean roleFlag=roleRelationMapper.modifyRoleRelation(roleUser);
        return (flag && roleFlag);
    }

    /**
     * 删除管理员信息
     * @param manageUserId
     * @return
     */
    public Boolean deleteAdmin(String manageUserId){
        return adminUserManageMapper.deleteAdmin(manageUserId);
    }

    /**
     * 查询管理员信息
     * @param manageUserInfo
     * @return
     */
    public List<ManageUserInfo> queryAdminUser(ManageUserInfo manageUserInfo){
        return adminUserManageMapper.queryAdminUser(manageUserInfo);
    }

    /**
     * 将该用户解冻可正常使用
     * @param manageUserId
     * @return
     */
    public Boolean modifyStatusAdmin(String manageUserId){
        return adminUserManageMapper.modifyStatusAdmin(manageUserId);
    }

    /**
     * 通过手机号查询用户
     *
     * @param userPhone
     * @return
     */
    public ManageUserInfo findByAdminUserPhone(String userPhone){
        return adminUserManageMapper.findByAdminUserPhone(userPhone);
    }

    /**
     * 修改管理员密码
     * @param manageUserId
     * @param newPwd
     * @return
     */
    public int modifyAdminUserPassword(String manageUserId,String newPwd){
        if(adminUserManageMapper.modifyAdminUserPassword(manageUserId,newPwd)){
            return 1;
        }
        return 0;
    }

}
