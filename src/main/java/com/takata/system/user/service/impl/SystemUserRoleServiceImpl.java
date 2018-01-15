package com.takata.system.user.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.user.dao.SystemUserRoleDao;
import com.takata.system.user.domain.SystemUserRole;
import com.takata.system.user.query.SystemUserRoleQuery;
import com.takata.system.user.service.SystemUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Service("systemUserRoleService")
public class SystemUserRoleServiceImpl implements SystemUserRoleService {

    @Resource(name = "systemUserRoleDao")
    private SystemUserRoleDao systemUserRoleDao;
    
    @Override
    public void addSystemUserRole(Integer userId, String[] roleIds) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        for (String roleId : roleIds){
            SystemUserRole systemUserRole = new SystemUserRole();
            systemUserRole.setUserId(userId);
            systemUserRole.setRoleId(Integer.valueOf(roleId));
            systemUserRole.setCreateBy(principal != null ? principal.getId() : null);
            systemUserRole.setCreateTime(new Date());
            systemUserRole.setUpdateBy(principal != null ? principal.getId() : null);
            systemUserRole.setUpdateTime(new Date());
            systemUserRole.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
            Integer count = this.systemUserRoleDao.insertSystemUserRole(systemUserRole);
            if (count != 1){
                throw new Exception("添加用户角色关联异常！");
            }
        }
    }

    @Override
    public void deleteSystemUserRole(SystemUserRole systemUserRole) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemUserRole.setUpdateBy(principal != null ? principal.getId() : null);
        systemUserRole.setUpdateTime(new Date());
        systemUserRole.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer count = this.systemUserRoleDao.updateSystemUserRole(systemUserRole);
        if (count != 1){
            throw new Exception("删除用户角色关联异常！");
        }
    }

    @Override
    public void deleteSystemUserRoleByUser(Integer userId) throws Exception {
        SystemUserRoleQuery systemUserRoleQuery = new SystemUserRoleQuery();
        systemUserRoleQuery.setUserId(userId);
        List<SystemUserRole> systemUserRoleList = this.listSystemUserRole(systemUserRoleQuery);
        for (SystemUserRole systemUserRole : systemUserRoleList){
            this.deleteSystemUserRole(systemUserRole);
        }
    }

    @Override
    public void deleteSystemUserRoleByRole(Integer roleId) throws Exception {
        SystemUserRoleQuery systemUserRoleQuery = new SystemUserRoleQuery();
        systemUserRoleQuery.setRoleId(roleId);
        List<SystemUserRole> systemUserRoleList = this.listSystemUserRole(systemUserRoleQuery);
        for (SystemUserRole systemUserRole : systemUserRoleList){
            this.deleteSystemUserRole(systemUserRole);
        }
    }

    @Override
    public List<SystemUserRole> listSystemUserRole(SystemUserRoleQuery systemUserRoleQuery) throws Exception {
        return this.systemUserRoleDao.selectSystemUserRoleList(systemUserRoleQuery);
    }

}
