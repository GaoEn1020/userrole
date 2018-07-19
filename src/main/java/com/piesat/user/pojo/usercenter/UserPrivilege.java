package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fanxiaodan on 2018/06/1.
 * 后管权限表
 */
public class UserPrivilege {
    //角色创建时间
    @JSONField(ordinal = 1,format = "YYYY-MM-dd HH:mm:ss")
    private Date roleCreateTime;
    //权限编号
    @JSONField(ordinal = 2)
    private String departId;
    //权限名称
    @JSONField(ordinal = 3)
    private String departName;
    //描述
    @JSONField(ordinal = 4)
    private String description;
    //父权限编号
    @JSONField(ordinal = 5)
    private String parentId;
    //角色编号
    @JSONField(ordinal = 6)
    private String roleId;
    //角色名称
    @JSONField(ordinal = 7)
    private String roleName;

    private String indexes;
    private String path;
    private String icon;

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    List<UserPrivilege> userPrivileges=new ArrayList<UserPrivilege>();

    public List<UserPrivilege> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(List<UserPrivilege> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }

    private String roleDescribe;

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

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
