package com.takata.system.role.controller;

import com.takata.system.constant.Url;
import com.takata.system.role.domain.SystemRoleMenu;
import com.takata.system.role.query.SystemRoleMenuQuery;
import com.takata.system.role.query.SystemRoleQuery;
import com.takata.system.role.service.SystemRoleMenuService;
import com.takata.system.role.service.SystemRoleService;
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
public class SystemRoleMenuController {

    @Resource(name = "systemRoleMenuService")
    private SystemRoleMenuService systemRoleMenuService;

    /**
     * 查询角色拥有的菜单权限
     * @param systemRoleMenurQuery 查询条件
     * @return 返回菜单权限列表
     */
    @RequestMapping(value = Url.ROLEMENU_QUERYROLEMENULIST)
    @ResponseBody
    private Object querySystemRoleMenuList(SystemRoleMenuQuery systemRoleMenurQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<SystemRoleMenu> systemRoleMenuList = this.systemRoleMenuService.listSystemRoleMenu(systemRoleMenurQuery);
            map.put("dataMapList", systemRoleMenuList);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 新增角色菜单关联
     * @param roleId 角色ID
     * @param menuIdStr 菜单ID字符串
     * @return 返回结果
     */
    @RequestMapping(value = Url.ROLEMENU_ADD)
    @ResponseBody
    private Object addSystemRoleMenu(Integer roleId, String menuIdStr){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            String[] menuIds = null;
            if(!(menuIdStr == null || "".equals(menuIdStr))){
                menuIds = menuIdStr.split(",");
            }
            this.systemRoleMenuService.addSystemRoleMenu(roleId, menuIds);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}