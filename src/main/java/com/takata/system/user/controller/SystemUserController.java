package com.takata.system.user.controller;

import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.constant.Url;
import com.takata.system.user.domain.SystemUser;
import com.takata.system.user.query.SystemUserQuery;
import com.takata.system.user.service.SystemUserService;
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
public class SystemUserController {

    @Resource(name = "systemUserService")
    private SystemUserService systemUserService;

    /**
     * 返回用户管理页面
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_DIALOG)
    private String getDialog(){
        return "system/user/systemUserList";
    }

    /**
     * 查询用户列表页面信息
     * @param systemUserQuery 用户列表页面查询条件
     * @return 返回用户分页列表信息和总数
     */
    @RequestMapping(value = Url.USER_QUERYPAGELIST)
    @ResponseBody
    private Object queryPageList(SystemUserQuery systemUserQuery){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            Principal principal = PrincipalUtils.getPrincipal();
            systemUserQuery.setCompanyId(principal.getCompanyId());
            List<Map<String, Object>> dataMapList = this.systemUserService.listSystemUserPage(systemUserQuery);
            Integer totalCount = this.systemUserService.countSystemUser(systemUserQuery);
            Integer totalPage = totalCount / systemUserQuery.getSize() + (totalCount % systemUserQuery.getSize() > 0 ? 1 : 0);
            map.put("dataMapList", dataMapList);
            map.put("totalCount", totalCount);
            map.put("totalPage", totalPage);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 新增用户
     * @param systemUser 用户实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_ADD)
    @ResponseBody
    private Object addUser(SystemUser systemUser){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.systemUserService.addSystemUser(systemUser);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 修改用户
     * @param systemUser 用户实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_EDIT)
    @ResponseBody
    private Object editUser(SystemUser systemUser){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.systemUserService.editSystemUser(systemUser);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 删除用户
     * @param systemUser 用户实体信息
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_DELETE)
    @ResponseBody
    private Object deleteUser(SystemUser systemUser){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            this.systemUserService.deleteSystemUser(systemUser);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 修改用户密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_EDITPASSWORD)
    @ResponseBody
    private Object editPassword(String oldPassword, String newPassword){
        Map<String, Object> map = new HashMap<String, Object>(4);
        try{
            Principal principal = PrincipalUtils.getPrincipal();
            this.systemUserService.editUserPassword(principal.getId(), oldPassword, newPassword);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 查询所有用户
     * @return 返回结果
     */
    @RequestMapping(value = Url.USER_QUERYALLUSER)
    @ResponseBody
    private Object queryAllUser(){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try{
            SystemUserQuery systemUserQuery = new SystemUserQuery();
            Principal principal = PrincipalUtils.getPrincipal();
            systemUserQuery.setCompanyId(principal.getCompanyId());
            List<SystemUser> dataMapList = this.systemUserService.listSystemUser(systemUserQuery);
            map.put("dataMapList", dataMapList);
            map.put("success", true);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

}
