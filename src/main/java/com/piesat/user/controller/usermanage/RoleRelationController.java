package com.piesat.user.controller.usermanage;


import com.piesat.user.pojo.result.ResultModelNew;
import com.piesat.user.pojo.result.ResultToolsNew;
import com.piesat.user.pojo.usercenter.ManageUserInfo;
import com.piesat.user.pojo.usercenter.Role;
import com.piesat.user.pojo.usercenter.RoleUser;
import com.piesat.user.pojo.usercenter.UserPrivilege;
import com.piesat.user.service.userservice.RoleRelationService;
import com.piesat.user.util.PagingUtils;
import com.piesat.user.util.StrUtil;
import com.piesat.user.util.TimeUtil;
import com.piesat.user.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/fengjing/roleRelation")
public class RoleRelationController {
    @Autowired
    private RoleRelationService roleRelationService;

    /**
     * 添加角色
     * @param map
     * @return
     */
    @RequestMapping("/addRole")
    public ResultModelNew addRole(@RequestBody Map<String,String> map){
        try{
            String roleName=null;
            String roleCreateTime=null;
            String roleDescribe=null;
            if( map.containsKey("roleDescribe")){
                roleDescribe=map.get("roleDescribe").toString();
            }
            if(map.containsKey("roleName") && map.containsKey("roleCreateTime") ){
                roleName=map.get("roleName").toString();
                roleCreateTime=map.get("roleCreateTime").toString();
                if(StrUtil.isNotNull(roleName) && StrUtil.isNotNull(roleCreateTime)){
                    Role role=new Role();
                    role.setRoleId(UUIDUtil.getUUID());
                    role.setRoleCreateTime(TimeUtil.str2Date(roleCreateTime,TimeUtil.datetimeFormat));
                    role.setRoleDescribe(roleDescribe);
                    role.setRoleName(roleName);
                    Boolean result=roleRelationService.addRole(role);//并添加为该角色添加一个权限
                    if(result){
                        return ResultToolsNew.result(true,"","添加成功");
                    }else {
                        return ResultToolsNew.result(false,"","添加失败");
                    }
                }else {
                    return ResultToolsNew.result(false,"角色名称和创建时间不能为空","");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 修改角色
     * @param map
     * @return
     */
    @RequestMapping("/modifyRole")
    public ResultModelNew modifyRole(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            String roleName=null;
            String roleCreateTime=null;
            String roleDescribe=null;
            if(map.containsKey("roleName") && map.containsKey("roleId") && map.containsKey("roleCreateTime") && map.containsKey("roleDescribe")){
                roleName=map.get("roleName").toString();
                roleCreateTime=map.get("roleCreateTime").toString();
                roleDescribe=map.get("roleDescribe").toString();
                roleId=map.get("roleId").toString();
                if(StrUtil.isNotNull(roleName) && StrUtil.isNotNull(roleId) && StrUtil.isNotNull(roleCreateTime)){
                    Role role=new Role();
                    role.setRoleCreateTime(TimeUtil.str2Date(roleCreateTime,TimeUtil.date_sdf));
                    role.setRoleDescribe(roleDescribe);
                    role.setRoleName(roleName);
                    role.setRoleId(roleId);
                    Boolean result=roleRelationService.modifyRole(role);
                    if(result){
                        return ResultToolsNew.result(true,"","修改成功");
                    }else {
                        return ResultToolsNew.result(false,"","修改失败");
                    }
                }else {
                    return ResultToolsNew.result(false,"角色名称和创建时间不能为空","");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 删除角色以及删除角色所分配的权限
     * @param map
     * @return
     */
    @RequestMapping("/deleteRole")
    public ResultModelNew deleteRole(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            if(map.containsKey("roleId")){
                roleId=map.get("roleId").toString();
                if(StrUtil.isNotNull(roleId)){
                    //先判断该角色是否有后管用户(所有后管用户)在使用，若有使用则不能删除
                    List<ManageUserInfo> manageUserInfos=roleRelationService.queryByRoleIdUserIdUsed(roleId);
                    if(manageUserInfos.size()>0){
                        return ResultToolsNew.result(false,"该角色有后管用户正在使用，不能删除","");
                    }
                    Boolean result=roleRelationService.deleteRole(roleId);
                    if(result){
                        return ResultToolsNew.result(true,"","删除成功");
                    }else {
                        return ResultToolsNew.result(false,"","删除失败");
                    }
                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 分页查询查询所有角色的基本信息
     * @param map
     * @return
     */
    @RequestMapping("/queryRoleBaseInfo")
    public ResultModelNew queryRoleBaseInfo(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            Integer pageNo=null;
            Integer pageCount=null;
            if(map.containsKey("roleId")){
                if(StrUtil.isNotNull(map.get("roleId"))){
                    roleId=map.get("roleId").toString();
                }
            }
            if(map.containsKey("pageNo") && map.containsKey("pageCount")){
                if(StrUtil.isNotNull(map.get("pageCount")) && StrUtil.isNotNull(map.get("pageNo"))){
                    pageCount=Integer.parseInt(map.get("pageCount").toString());
                    pageNo=Integer.parseInt(map.get("pageNo").toString());

                    List<Role> roles=roleRelationService.queryRoleBaseInfo(roleId);
                    Map<String,Object> roleMap=new HashMap<String, Object>();
                    roleMap.put("sumCount",roles.size());
                    roleMap.put("roleList", PagingUtils.getPageInfo(roles,pageNo,pageCount));
                    return ResultToolsNew.result(true,"",roleMap);
                }else {
                    return ResultToolsNew.result(false,"分页参数不能为空","");
                }

            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }
    /**
     * 查询所有角色的基本信息
     * @param map
     * @return
     */
    @RequestMapping("/queryRoleAllInfo")
    public ResultModelNew queryRoleAllInfo(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            if(map.containsKey("roleId")){
                if(StrUtil.isNotNull(map.get("roleId"))){
                    roleId=map.get("roleId").toString();
                }
            }
            List<Role> roles=roleRelationService.queryRoleBaseInfo(roleId);
            return ResultToolsNew.result(true,"",roles);
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }
    /**
     * 根据角色编号查询权限  或查询所有角色以及角色下的权限
     * @param map
     * @return
     */
    @RequestMapping("/queryByRoleId")
    public ResultModelNew queryByRoleId(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            if(map.containsKey("roleId")){
                if(StrUtil.isNotNull(map.get("roleId").toString())){
                    roleId=map.get("roleId").toString();
                }
                List<UserPrivilege> userPrivileges=roleRelationService.queryByRoleId(roleId);
                return ResultToolsNew.result(true,"",userPrivileges);
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 添加用户角色 或 修改用户角色
     * @param map
     * @return
     */
    @RequestMapping("/addOrModifyRoleRelation")
    public ResultModelNew addOrModifyRoleRelation(@RequestBody Map<String,String> map){
        try{
            String roleId=null;
            String manageUserId=null;
            if(map.containsKey("roleId") && map.containsKey("manageUserId")){
                roleId=map.get("roleId").toString();
                manageUserId=map.get("manageUserId").toString();
                if(StrUtil.isNotNull(roleId) && StrUtil.isNotNull(manageUserId)){

                    //查询用户是否有角色
                    List<RoleUser> roleUsers=roleRelationService.queryByUserId(manageUserId);
                    if(roleUsers.size()<=0) {
                        RoleUser roleUser = new RoleUser();
                        roleUser.setUserTRoleId(UUIDUtil.getUUID());
                        roleUser.setRoleId(roleId);
                        roleUser.setManageUserId(manageUserId);
                        Boolean result = roleRelationService.addroleRelation(roleUser);
                        if (result) {
                            return ResultToolsNew.result(true, "", "添加成功");
                        } else {
                            return ResultToolsNew.result(false, "", "添加失败");
                        }
                    }else{
                        //修改
                        if(roleId.equals(roleUsers.get(0).getRoleId())){
                            return ResultToolsNew.result(false,"该用户角色与之前角色一致无需修改","");
                        }
                        RoleUser roleUser=new RoleUser();
                        roleUser.setRoleId(roleId);
                        roleUser.setManageUserId(manageUserId);
                        Boolean result=roleRelationService.modifyRoleRelation(roleUser);
                        if(result){
                            return ResultToolsNew.result(true,"","修改成功");
                        }else {
                            return ResultToolsNew.result(false,"","修改失败");
                        }
                    }
                }else {
                    return ResultToolsNew.result(false,"参数不能为空","");
                }
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 根据管理员编号进行查询角色及权限 或查询所有
     * @param map
     * @return
     */
    @RequestMapping("/queryByUserId")
    public ResultModelNew queryByUserId(@RequestBody Map<String,String> map){
        try{
            String manageUserId=null;
            if(map.containsKey("manageUserId")){
                if(StrUtil.isNotNull(map.get("manageUserId").toString())){
                    manageUserId=map.get("manageUserId").toString();
                }
                List<RoleUser> roleUsers=roleRelationService.queryByUserId(manageUserId);
                return ResultToolsNew.result(true,"",roleUsers);
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 根据权限编号查询权限或查询所有权限
     * @param map
     * @return
     */
    @RequestMapping("/queryBydepartId")
    public ResultModelNew queryBydepartId(@RequestBody Map<String,String> map){
        try{
            String departId=null;
            if(map.containsKey("departId")){
                if(StrUtil.isNotNull(map.get("departId").toString())){
                    departId=map.get("departId").toString();
                }
                List<UserPrivilege> userPrivileges=roleRelationService.queryBydepartId(departId);
                return ResultToolsNew.result(true,"",userPrivileges);
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 根据父节点查询权限的子节点
     * @param map
     * @return
     */
    @RequestMapping("/queryByParentChild")
    public ResultModelNew queryByParentChild(@RequestBody Map<String,String> map){
        try{
            String parentId=null;
            if(map.containsKey("parentId")){
                if(StrUtil.isNotNull(map.get("parentId").toString())){
                    parentId=map.get("parentId").toString();
                }
                List<UserPrivilege> userPrivileges=roleRelationService.queryByParentChild(parentId);
                return ResultToolsNew.result(true,"",userPrivileges);
            }else {
                return ResultToolsNew.result(false,"参数格式不正确","");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

    /**
     * 为角色配置权限  或 修改角色权限
     * @param map
     * @return
     */
    @RequestMapping("/addOrModifyRolePrivilege")
    public ResultModelNew addOrModifyRolePrivilege(@RequestBody Map<String,String> map){
        try{
            if(map.containsKey("roleId") && map.containsKey("privileges")) {
                String roleId = map.get("roleId").toString();
                String[] privileges = map.get("privileges").toString().split(",");
                //接收权限编号
                if (StrUtil.isNotNull(roleId) && privileges.length > 0) {
                    //查询该角色是否已经有权限（若有权限则修改，若没有则添加）
                    List<UserPrivilege> userPrivileges = roleRelationService.queryByRoleId(roleId);
                    if (!StrUtil.isNotNull(userPrivileges.get(0).getDepartId())) {
                        Boolean result = roleRelationService.addRolePrivilege(privileges, roleId);
                        if (result) {
                            return ResultToolsNew.result(true, "", "配置成功");
                        } else {
                            return ResultToolsNew.result(false, "配置失败", "");
                        }
                    } else {
                        Boolean result = roleRelationService.modifyRolePrivilege(privileges, roleId);
                        if (result) {
                            return ResultToolsNew.result(true, "", "修改角色权限成功");
                        } else {
                            return ResultToolsNew.result(false, "修改角色权限失败", "");
                        }
                    }
                } else {
                    return ResultToolsNew.result(false, "参数不能为空", "");
                }
            } else {
                return ResultToolsNew.result(false, "参数格式错误", "");
            }
        }catch (Exception e){
            return ResultToolsNew.result(false,e.getMessage(),"");
        }
    }

}
