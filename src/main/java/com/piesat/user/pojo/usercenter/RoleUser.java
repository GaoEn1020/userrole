package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by fanxiaodan on 2018/06/1.
 * 角色用户表  对应数据库中RoleUser表
 */
public class RoleUser {
    //用户角色编号
    @JSONField(ordinal = 1)
    private String userTRoleId;
    //角色编号
    @JSONField(ordinal = 2)
    private String roleId;
    //后管用户编号
    @JSONField(ordinal = 3)
    private String manageUserId;

    private String roleName;

    private List<UserPrivilege> roles;

    public List<UserPrivilege> getRoles() {
        return roles;
    }

    public void setRoles(List<UserPrivilege> roles) {
        this.roles = roles;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserTRoleId() {
        return userTRoleId;
    }

    public void setUserTRoleId(String userTRoleId) {
        this.userTRoleId = userTRoleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(String manageUserId) {
        this.manageUserId = manageUserId;
    }
}
