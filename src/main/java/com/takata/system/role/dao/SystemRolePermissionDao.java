package com.takata.system.role.dao;

import com.takata.common.dao.BaseDao;
import com.takata.system.role.domain.SystemRolePermission;
import com.takata.system.role.query.SystemRolePermissionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lzf
 **/
@Repository
public class SystemRolePermissionDao extends BaseDao {

    /**
     * 新增角色权限关联
     * @param systemRolePermission 角色权限关联实体信息
     * @return 返回结果
     * @throws Exception 异常
     */
    public Integer insertSystemRolePermission(SystemRolePermission systemRolePermission) {
        return this.writerSqlSession.insert("SystemRolePermissionMapper.insertSystemRolePermission", systemRolePermission);
    }

    /**
     * 修改角色权限关联信息
     * @param systemRolePermission 角色权限关联实体信息
     * @return 返回结果
     * @throws Exception 异常
     */
    public Integer updateSystemRolePermission(SystemRolePermission systemRolePermission) {
        return this.writerSqlSession.update("SystemRolePermissionMapper.updateSystemRolePermission", systemRolePermission);
    }

    /**
     * 查询角色权限关联列表
     * @param systemRolePermissionQuery 查询条件
     * @return 返回列表数据
     */
    public List<SystemRolePermission> selectSystemRolePermissionList(SystemRolePermissionQuery systemRolePermissionQuery){
        return this.readSqlSession.selectList("SystemRolePermissionMapper.selectSystemRolePermissionList", systemRolePermissionQuery);
    }
    
}
