package com.piesat.user.pojo.usercenter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by fanxiaodan on 2018/06/1.
 * 角色权限表  对应数据库Trolerelation表
 */
public class Trolerelation {
    //角色权限编号
    @JSONField(ordinal = 1)
    private String tRoleRelationId;
    //角色编号
    @JSONField(ordinal = 2)
    private String roleId;
    //权限编号
    @JSONField(ordinal = 3)
    private String departId;
    //权限名称
    @JSONField(ordinal = 4)
    private String departName;

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String gettRoleRelationId() {
        return tRoleRelationId;
    }

    public void settRoleRelationId(String tRoleRelationId) {
        this.tRoleRelationId = tRoleRelationId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
}
