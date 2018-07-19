package com.piesat.user.mapper.usermapper;

import com.piesat.user.pojo.usercenter.ManageUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fanxiaodan on 2018/05/31.
 */
@Repository
public interface AdminUserManageMapper {

    /**
     * 添加管理员信息
     * @return
     */
    Boolean addAdmin(ManageUserInfo manageUserInfo);
//    计算编号的后两位
String queryByManageUserId();
    /**
     * 修改管理员信息
     * @param manageUserInfo
     * @return
     */
    Boolean modifyAdmin(ManageUserInfo manageUserInfo);

    /**
     * 通过用户名查询对象
     *
     * @param userName
     * @return
     */
    ManageUserInfo selectByName(@Param(value = "userName") String userName);

    /**
     * 删除管理员信息
     * @param manageUserId
     * @return
     */
    Boolean deleteAdmin(String manageUserId);

    /**
     * 查询管理员信息
     * @param manageUserInfo
     * @return
     */
    List<ManageUserInfo> queryAdminUser(ManageUserInfo manageUserInfo);

    /**
     * 将该用户解冻可正常使用
     * @param manageUserId
     * @return
     */
    Boolean modifyStatusAdmin(@Param("manageUserId") String manageUserId);


    /**
     * 通过手机号查询用户
     *
     * @param userPhone
     * @return
     */
    public ManageUserInfo findByAdminUserPhone(@Param("userPhone") String userPhone);

    /**
     * 修改管理员密码
     * @param manageUserId
     * @param newPwd
     * @return
     */
    public Boolean modifyAdminUserPassword(@Param("manageUserId") String manageUserId, @Param("newPwd") String newPwd);
}
