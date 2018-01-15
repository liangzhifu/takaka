package com.takata.system.permission.service.impl;

import com.takata.system.permission.dao.SystemPermissionDao;
import com.takata.system.permission.domain.SystemPermission;
import com.takata.system.permission.service.SystemPermissionService;
import com.takata.system.role.query.SystemRolePermissionQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzf
 **/
@Service("systemPermissionService")
public class SystemPermissionServiceImpl implements SystemPermissionService {

    @Resource(name = "systemPermissionDao")
    private SystemPermissionDao systemPermissionDao;

    @Override
    public List<SystemPermission> listAddSystemPermission(SystemRolePermissionQuery systemRolePermissionQuery) throws Exception {
        return this.systemPermissionDao.selectAddSystemPermissionList(systemRolePermissionQuery);
    }
}
