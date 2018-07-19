package com.piesat.user.service.userservice;


import com.piesat.user.mapper.usermapper.RoleRelationMapper;
import com.piesat.user.pojo.usercenter.*;
import com.piesat.user.util.StrUtil;
import com.piesat.user.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Created by fanxiaodan on 2018/06/01
 */
@Service
@Transactional
public class RoleRelationService {
    @Autowired
    private RoleRelationMapper roleRelationMapper;

    /**
     * 添加角色
     * @return
     */
    public Boolean addRole(Role role){
        Boolean flag=roleRelationMapper.addRole(role);//角色的普通属性
        //为该角色添加首页权限
        String[] privileges={"001"};
        Boolean result=addRolePrivilege(privileges, role.getRoleId());
        return (flag);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    public Boolean modifyRole(Role role){
        Boolean flag=roleRelationMapper.modifyRole(role);//修改角色的普通属性
        return (flag);
    }

    /**
     * 先判断该角色是否有后管用户在使用，若有使用则不能删除
     * @param roleId
     * @return
     */
    public List<ManageUserInfo> queryByRoleIdUserIdUsed(String roleId){
        return roleRelationMapper.queryByRoleIdUserIdUsed(roleId);
    }

    /**
     * 删除角色以及删除角色所分配的权限
     * @param roleId
     * @return
     */
    public Boolean deleteRole(String roleId){
        //先进行删除该角色的权限
        Boolean flagPrivilege=true;
        List<UserPrivilege> list=roleRelationMapper.queryByRoleId(roleId);
        if(StrUtil.isNotNull(list.get(0).getDepartId())) {
            flagPrivilege = roleRelationMapper.deleteRolePrivilege(roleId);
        }
        //在删除角色
        if(flagPrivilege){
            return roleRelationMapper.deleteRole(roleId);
        }
        return flagPrivilege;
    }
    /**
     * 根据角色编号查询权限  或查询所有角色以及角色下的权限
     * @param roleId
     * @return
     */
    public List<UserPrivilege> queryByRoleId(String roleId){
        return roleRelationMapper.queryByRoleId(roleId);
    }

    /**
     * 添加用户角色
     * @return
     */
    public Boolean addroleRelation(RoleUser roleUser){
        return roleRelationMapper.addroleRelation(roleUser);
    }

    /**
     * 修改用户角色
     * @param roleUser
     * @return
     */
    public Boolean modifyRoleRelation(RoleUser roleUser){
        return roleRelationMapper.modifyRoleRelation(roleUser);
    }

    /**
     * 查询所有角色的基本信息
     */
    public List<Role> queryRoleBaseInfo(String roleId){
        return roleRelationMapper.queryRoleBaseInfo(roleId);
    }

    /**
     * 根据管理员编号进行查询角色及权限 或查询所有
     * @param manageUserId
     * @return
     */
    public List<RoleUser> queryByUserId(String manageUserId){
        List<RoleUser> roleUsers= roleRelationMapper.queryByUserId(manageUserId);
        //查询此角色的权限
        for(RoleUser roleUser:roleUsers) {
            List<UserPrivilege> userPrivileges = queryByRoleId(roleUser.getRoleId());
            roleUser.setRoles(queryAllChild("0",roleUser.getRoleId()));
        }
        return roleUsers;
    }


    /**
     * 根据权限编号查询权限或查询所有权限
     * @param departId
     * @return
     */
    public List<UserPrivilege> queryBydepartId(String departId){
        return roleRelationMapper.queryBydepartId(departId);
    }

    /**
     * 为角色配置权限
     * @param departs  权限编号数组
     * @param roleId  角色编号
     * @return
     */
    public Boolean addRolePrivilege(String[] departs,String roleId){
        Boolean flag=true;
        for(String depart:departs){
            Trolerelation trolerelation=new Trolerelation();
            trolerelation.setRoleId(roleId);
            trolerelation.setDepartId(depart);
            trolerelation.settRoleRelationId(UUIDUtil.getUUID());
            //添加到角色权限相关表中
            Boolean privilegeFlag=roleRelationMapper.addRolePrivilege(trolerelation);
            if(!privilegeFlag){
                flag=false;
                break;
            }
        }
        return flag;
    }

    /**
     * 修改角色权限
     * @param departs  权限编号数组
     * @param roleId   角色编号
     * @return
     */
    public Boolean modifyRolePrivilege(String[] departs,String roleId){
        //删除该角色的权限
        Boolean flag=roleRelationMapper.deleteRolePrivilege(roleId);
        if(flag){
            //添加角色
            return addRolePrivilege(departs,roleId);
        }
        return flag;
    }


    /**
     * 查询角色权限
     * @param parentId  权限的父权限编号
     * @return
     */
    public List<UserPrivilege> queryByParentChild(String parentId){
        //如果parentId为空则查询所有
        return queryAllChild(parentId,"");
    }

    /**
     * 查询所有子节点
     * @param parentId  父节点编号
     * @return
     */
    private List<UserPrivilege> queryAllChild(String parentId,String roleId){
        List<UserPrivilege> userPrivileges=roleRelationMapper.queryByParentChild(parentId,roleId);
        for(UserPrivilege userPrivilege:userPrivileges){
            List<UserPrivilege> userPrivilegeList=queryAllChild(userPrivilege.getDepartId(),roleId);
            if (userPrivilegeList.size()<=0){
                continue;
            }
            userPrivilege.setUserPrivileges(userPrivilegeList);
        }
        return userPrivileges;
    }

}