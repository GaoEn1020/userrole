package com.piesat.user.mapper.usermapper;

import com.piesat.user.pojo.usercenter.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fanxiaodan on 2018/06/01.
 */
@Repository
public interface RoleRelationMapper {
    /**
     * 添加用户角色
     * @return
     */
    Boolean addroleRelation(RoleUser roleUser);

    /**
     * 修改用户角色
     * @param roleUser
     * @return
     */
    Boolean modifyRoleRelation(RoleUser roleUser);

    /**
     * 根据管理员编号进行查询
     * @param manageUserId
     * @return
     */
    List<RoleUser> queryByUserId(@Param("manageUserId") String manageUserId);

    /**
     * 根据角色编号查询权限或查询所有角色的所有权限
     * @param roleId
     * @return
     */
    List<UserPrivilege> queryByRoleId(@Param("roleId") String roleId);

    /**
     * 根据权限编号查询权限或查询所有权限
     * @param departId
     * @return
     */
    List<UserPrivilege> queryBydepartId(@Param("departId") String departId);

    /**
     * 添加角色
     * @return
     */
    Boolean addRole(Role role);

    /**
     * 查询所有角色的基本信息
     */
    List<Role> queryRoleBaseInfo(@Param("roleId") String roleId);

    //添加角色权限
    Boolean addRolePrivilege(Trolerelation trolerelation);

    //修改角色的普通属性
    Boolean modifyRole(Role role);

    /**
     * 先判断该角色是否有后管用户在使用，若有使用则不能删除
     * @param roleId
     * @return
     */
    List<ManageUserInfo> queryByRoleIdUserIdUsed(@Param("roleId") String roleId);

    //删除该角色的所有权限
    Boolean deleteRolePrivilege(@Param("roleId") String roleId);

    //在角色表中删除该角色
    Boolean deleteRole(@Param("roleId") String roleId);

    //根据父类编号进行查询
    List<UserPrivilege> queryByParentChild(@Param("parentId") String parentId, @Param("roleId") String roleId);
}
