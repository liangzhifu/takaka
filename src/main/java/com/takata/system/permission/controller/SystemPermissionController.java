package com.takata.system.permission.controller;

import com.takata.system.constant.Url;
import com.takata.system.permission.domain.SystemPermission;
import com.takata.system.permission.service.SystemPermissionService;
import com.takata.system.role.query.SystemRolePermissionQuery;
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
public class SystemPermissionController {

    @Resource(name = "systemPermissionService")
    private SystemPermissionService systemPermissionService;

    /**
     * 查询可以加入权限的列表
     * @param systemRolePermissionQuery 可以加入权限的列表查询条件
     * @return 返回可以加入权限的列表信息和总数
     */
    @RequestMapping(value = Url.PERMISSION_ADDLIST)
    @ResponseBody
    private Object queryAddSystemPermissionList(SystemRolePermissionQuery systemRolePermissionQuery){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            List<SystemPermission> systemPermissionList = this.systemPermissionService.listAddSystemPermission(systemRolePermissionQuery);
            map.put("dataMapList", systemPermissionList);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
