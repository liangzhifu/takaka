package com.takata.system.user.dao;

import com.takata.common.dao.BaseDao;
import com.takata.system.user.domain.SystemUserOrg;
import com.takata.system.user.query.SystemUserOrgQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzf
 **/
@Repository
public class SystemUserOrgDao extends BaseDao {

    /**
     * 新增用户组织关联
     * @param systemUserOrg 用户组织关联实体信息
     * @return 返回结果
     */
    public Integer insertSystemUserOrg(SystemUserOrg systemUserOrg) {
        return this.writerSqlSession.insert("SystemUserOrgMapper.insertSystemUserOrg", systemUserOrg);
    }

    /**
     * 修改用户组织关联信息
     * @param systemUserOrg 用户组织关联实体信息
     * @return 返回结果
     */
    public Integer updateSystemUserOrg(SystemUserOrg systemUserOrg) {
        return this.writerSqlSession.update("SystemUserOrgMapper.updateSystemUserOrg", systemUserOrg);
    }

    /**
     * 查询用户组织关联列表
     * @param systemUserOrgQuery 查询条件
     * @return 返回列表数据
     */
    public List<SystemUserOrg> selectSystemUserOrgList(SystemUserOrgQuery systemUserOrgQuery){
        return this.readSqlSession.selectList("SystemUserOrgMapper.selectSystemUserOrgList", systemUserOrgQuery);
    }

}
