package com.takata.system.role.service.impl;

import com.takata.common.constant.CommonEnum;
import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.role.dao.SystemRoleMenuDao;
import com.takata.system.role.domain.SystemRoleMenu;
import com.takata.system.role.query.SystemRoleMenuQuery;
import com.takata.system.role.service.SystemRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzf
 **/
@Service("systemRoleMenuService")
public class SystemRoleMenuServiceImpl implements SystemRoleMenuService {

    @Resource(name = "systemRoleMenuDao")
    private SystemRoleMenuDao systemRoleMenuDao;

    @Override
    public void addSystemRoleMenu(Integer roleId, String[] menuIds) throws Exception {
        //删除旧的角色菜单关联
        this.deleteSystemRoleMenuByRole(roleId);

        //增加新的角色菜单关联
        SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
        Principal principal = PrincipalUtils.getPrincipal();
        systemRoleMenu.setCreateBy(principal != null ? principal.getId() : null);
        systemRoleMenu.setCreateTime(new Date());
        systemRoleMenu.setUpdateBy(principal != null ? principal.getId() : null);
        systemRoleMenu.setUpdateTime(new Date());
        systemRoleMenu.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_NO.getCode());
        for (String menuId : menuIds){
            systemRoleMenu.setRoleId(roleId);
            systemRoleMenu.setMenuId(Integer.valueOf(menuId));
            systemRoleMenu.setId(null);
            Integer count = this.systemRoleMenuDao.insertSystemRoleMenu(systemRoleMenu);
            if (count != 1){
                throw new Exception("添加角色权限关联异常！");
            }
        }
    }

    @Override
    public void deleteSystemRoleMenu(SystemRoleMenu systemRoleMenu) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        systemRoleMenu.setUpdateBy(principal != null ? principal.getId() : null);
        systemRoleMenu.setUpdateTime(new Date());
        systemRoleMenu.setDeleteState(CommonEnum.DeleteStateEnum.DELETE_STATE_YES.getCode());
        Integer count = this.systemRoleMenuDao.updateSystemRoleMenu(systemRoleMenu);
        if (count != 1){
            throw new Exception("删除角色权限关联异常！");
        }
    }

    @Override
    public void deleteSystemRoleMenuByRole(Integer roleId) throws Exception {
        SystemRoleMenuQuery systemRoleMenuQuery = new SystemRoleMenuQuery();
        systemRoleMenuQuery.setRoleId(roleId);
        List<SystemRoleMenu> systemRoleMenuList = this.listSystemRoleMenu(systemRoleMenuQuery);
        for (SystemRoleMenu systemRoleMenu : systemRoleMenuList){
            this.deleteSystemRoleMenu(systemRoleMenu);
        }
    }

    @Override
    public void deleteSystemRoleMenuByMenu(Integer menuId) throws Exception {
        SystemRoleMenuQuery systemRoleMenuQuery = new SystemRoleMenuQuery();
        systemRoleMenuQuery.setMenuId(menuId);
        List<SystemRoleMenu> systemRoleMenuList = this.listSystemRoleMenu(systemRoleMenuQuery);
        for (SystemRoleMenu systemRoleMenu : systemRoleMenuList){
            this.deleteSystemRoleMenu(systemRoleMenu);
        }
    }

    @Override
    public List<SystemRoleMenu> listSystemRoleMenu(SystemRoleMenuQuery systemRoleMenuQuery) throws Exception {
        return this.systemRoleMenuDao.selectSystemRoleMenuList(systemRoleMenuQuery);
    }
}
