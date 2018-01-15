package com.takata.system.user.controller;

import com.takata.system.constant.Url;
import com.takata.system.user.domain.SystemUserRole;
import com.takata.system.user.query.SystemUserRoleQuery;
import com.takata.system.user.service.SystemUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Slf4j
@Controller
public class SystemUserRoleController {

    @Resource(name = "systemUserRoleService")
    private SystemUserRoleService systemUserRoleService;

    /**
     * 查询用户角色关联列表页面信息
     * @param systemUserRoleQuery 用户角色关联列表页面查询条件
     * @return 返回用户角色关联分页列表信息和总数
     */
    @RequestMapping(value = Url.USERROLE_QUERYLIST)
    @ResponseBody
    private Object querySystemUserRolePageList(SystemUserRoleQuery systemUserRoleQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<SystemUserRole> dataMapList = this.systemUserRoleService.listSystemUserRole(systemUserRoleQuery);
            map.put("dataMapList", dataMapList);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 新增用户角色关联
     * @param userId 用户ID
     * @param roleIdStr 角色ID字符串
     * @return 返回结果
     */
    @RequestMapping(value = Url.USERROLE_ADD)
    @ResponseBody
    private Object addSystemUserRole(Integer userId, String roleIdStr){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            String[] roleIds = roleIdStr.split(",");
            this.systemUserRoleService.addSystemUserRole(userId, roleIds);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 删除用户角色关联
     * @param systemUserRole 角色实体
     * @return 返回结果
     */
    @RequestMapping(value = Url.USERROLE_DELETE)
    @ResponseBody
    private Object deleteSystemUserRole(SystemUserRole systemUserRole){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.systemUserRoleService.deleteSystemUserRole(systemUserRole);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
