package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * Created by fanxiaodan on 2018/06/1.
 * 角色表  对应数据库中Role表
 */
public class Role {
    //角色编号
    @JSONField(ordinal = 1)
    private String roleId;
    //角色名称
    @JSONField(ordinal = 2)
    private String roleName;
    //角色创建时间
    @JSONField(ordinal = 3, format = "YYYY-MM-dd HH:mm:ss")
    private Date roleCreateTime;
    //角色描述
    @JSONField(ordinal = 4)
    private String roleDescribe;

    //角色表中的权限
    private List<UserPrivilege> userPrivilegeList;

    public List<UserPrivilege> getUserPrivilegeList() {
        return userPrivilegeList;
    }

    public void setUserPrivilegeList(List<UserPrivilege> userPrivilegeList) {
        this.userPrivilegeList = userPrivilegeList;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(Date roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }
}
