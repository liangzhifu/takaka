package com.takata.system.permission.dao;

import com.takata.common.dao.BaseDao;
import com.takata.system.permission.domain.SystemPermission;
import com.takata.system.role.query.SystemRolePermissionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class SystemPermissionDao extends BaseDao {

    /**
     * 查询可以添加的权限列表
     * @param systemRolePermissionQuery 查询条件
     * @return 返回结果
     */
    public List<SystemPermission> selectAddSystemPermissionList(SystemRolePermissionQuery systemRolePermissionQuery){
        return this.readSqlSession.selectList("SystemPermissionMapper.selectAddSystemPermissionList", systemRolePermissionQuery);
    }
}
