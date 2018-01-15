package com.takata.system.role.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.role.dao.SystemRoleDao;
import com.takata.system.role.domain.SystemRole;
import com.takata.system.role.query.SystemRoleQuery;
import com.takata.system.role.service.SystemRoleMenuService;
import com.takata.system.role.service.SystemRolePermissionService;
import com.takata.system.role.service.SystemRoleService;
import com.takata.system.user.domain.SystemUserRole;
import com.takata.system.user.query.SystemUserRoleQuery;
import com.takata.system.user.service.SystemUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService {

    @Resource(name = "systemRoleDao")
    private SystemRoleDao systemRoleDao;

    @Resource(name = "systemUserRoleService")
    private SystemUserRoleService systemUserRoleService;

    @Resource(name = "systemRoleMenuService")
    private SystemRoleMenuService systemRoleMenuService;

    @Resource(name = "systemRolePermissionService")
    private SystemRolePermissionService systemRolePermissionService;

    @Override
    public Integer addSystemRole(SystemRole systemRole) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemRole.setCreateBy(principal != null ? principal.getId() : null);
        systemRole.setCreateTime(new Date());
        systemRole.setUpdateBy(principal != null ? principal.getId() : null);
        systemRole.setUpdateTime(new Date());
        systemRole.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        Integer count = this.systemRoleDao.insertSystemRole(systemRole);
        if (count != 1){
            throw new Exception("添加角色异常！");
        }
        return count;
    }

    @Override
    public Integer editSystemRole(SystemRole systemRole) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemRole.setUpdateBy(principal != null ? principal.getId() : null);
        systemRole.setUpdateTime(new Date());
        Integer count = this.systemRoleDao.updateSystemRole(systemRole);
        if (count != 1){
            throw new Exception("修改角色异常！");
        }
        return count;
    }

    @Override
    public Integer deleteSystemRole(SystemRole systemRole) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemRole.setUpdateBy(principal != null ? principal.getId() : null);
        systemRole.setUpdateTime(new Date());
        systemRole.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer count = this.systemRoleDao.updateSystemRole(systemRole);
        if (count != 1){
            throw new Exception("删除角色异常！");
        }

        //删除角色菜单关联
        this.systemRoleMenuService.deleteSystemRoleMenuByRole(systemRole.getId());

        //删除角色权限关联
        this.systemRolePermissionService.deleteSystemPermissionByRole(systemRole.getId());

        //删除用户角色关联
        this.systemUserRoleService.deleteSystemUserRoleByRole(systemRole.getId());

        return count;
    }

    @Override
    public List<SystemRole> listSystemRolePage(SystemRoleQuery systemRoleQuery) throws Exception {
        return this.systemRoleDao.selectSystemRolePageList(systemRoleQuery);
    }

    @Override
    public Integer countSystemRole(SystemRoleQuery systemRoleQuery) throws Exception {
        return this.systemRoleDao.selectSystemRoleCount(systemRoleQuery);
    }

    @Override
    public List<SystemRole> listAddRole(SystemUserRoleQuery systemUserRoleQuery) throws Exception {
        return this.systemRoleDao.selectAddSystemRoleList(systemUserRoleQuery);
    }

}
